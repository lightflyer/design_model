package DesignModel;

// 解释器模式提供了评估语言的语法或表达式的方式,实现了一个表达式接口,该接口解释一个特定的上下文.
// 主要解决:对于一些固定文法构建一个解释句子的解释器

// 例子

interface Expression{
    public boolean interpret(String context);
}

class TerminalExpression implements Expression{

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)){
            return true;
        }
        return false;
    }
}

class OrExpression implements Expression{
    private Expression expr1 = null;
    private Expression expr2 = null;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}

class AndExpression implements Expression{

    private Expression expr1 = null;
    private Expression expr2 = null;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}
public class InterpreterModel {

    //规则: R 和 J 是男性
    public  static Expression getMaleExpression(){
        Expression r = new TerminalExpression("R");
        Expression j = new TerminalExpression("J");
        return new OrExpression(r, j);
    }

    //规则: Y 是一个已婚女性
    public static Expression getMarriedWomenExpression(){
        Expression x = new TerminalExpression("X");
        Expression y = new TerminalExpression("Y");
        return new AndExpression(x, y);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWomen = getMarriedWomenExpression();

        System.out.println("J is male? " + isMale.interpret("J"));
        System.out.println("Y is married? " + isMarriedWomen.interpret("Y"));
    }
}
