package DesignModel;

// 在访问者模式中,通过改变了元素类的执行算法.通过这种方式,元素的执行算法可以随着访问者改变而改变.
// 主要解决: 稳定的数据结构和易变的操作耦合问题.

interface ComputerPart{
    public void accept(ComputerPartVisitor computerPartVisitor);
}

class Keyboard implements ComputerPart{

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

class Monitor implements ComputerPart{

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

class Mouse implements ComputerPart{

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

interface ComputerPartVisitor{
    public void visit(Computer computer);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);
    public void visit(Mouse mouse);
}

class Computer implements ComputerPart{
    ComputerPart[] parts;

    public Computer(){
        parts = new ComputerPart[]{new Mouse(), new Keyboard(), new Monitor()};
    }
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for(int i = 0; i < parts.length; i++){
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}

public class VisitorModel implements ComputerPartVisitor{
    @Override
    public void visit(Computer computer) {
        System.out.println("Visiting Computer");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Visiting Keyboard");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Visiting Monitor");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Visiting Mouse");
    }

    public static void main(String[] args) {
        ComputerPart computer = new Computer();
        computer.accept(new VisitorModel());
    }
}
