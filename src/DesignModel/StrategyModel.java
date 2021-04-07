package DesignModel;

// 策略模式定义了一系列算法,并将每个算法封装起来,使他们可以互相替换;一个类的行为或者算法可以在运行时更改;
// 主要解决:在有多种算法相似的前提下,使用if...else所带来的的复杂和难以维护.

// 例子:加、减、乘法则


interface Strategy{
    public int doOperation(int num1, int num2);
}


class OperationAdd implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSub implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationMultiply implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

public class StrategyModel {

    private Strategy strategy;

    public StrategyModel(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return this.strategy.doOperation(num1, num2);
    }

    public static void main(String[] args) {

        StrategyModel test = new StrategyModel(new OperationAdd());
        System.out.println("10 + 5 = " + test.executeStrategy(10, 5));

        test = new StrategyModel(new OperationSub());
        System.out.println("10 - 5 = " + test.executeStrategy(10, 5));

        test = new StrategyModel(new OperationMultiply());
        System.out.println("10 * 5 = " + test.executeStrategy(10, 5));

    }


}
