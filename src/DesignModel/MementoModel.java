package DesignModel;

// 保存一个对象的摸个状态,以便在适当的时候恢复对象.
// 主要解决: 在不破坏封装的前提下,捕获一个对象的内部状态,并在该对象之外保存这个状态,这样可以在以后将对象汇付宝原先保存的状态
// 注意事项: 1、为了符合迪米特法则(最少知道法则),还要增加一个管理忘备录的类. 2、为了节约内存,可以使用原型模式+备忘录模式

// 例子:Memento包含了要被恢复对象的状态.Originator创建并在Memento对象中存储状态.MementoModel对象负责从Memento中恢复对象的状态.

import java.util.ArrayList;
import java.util.List;

class Memento{
    private String state;
    public Memento(String state){
        this.state =state;
    }

    public String getState() {
        return state;
    }
}

class Originator{
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento(){
        return new Memento(this.state);
    }

    public void getStateFromMemento(Memento memento){
        this.state = memento.getState();
    }
}

public class MementoModel {

    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento memento){
        mementoList.add(memento);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }

    public static void main(String[] args) {

        Originator originator = new Originator();
        MementoModel test = new MementoModel();

        originator.setState("state 1");
        originator.setState("state 2");
        test.add(originator.saveStateToMemento());
        originator.setState("state 3");
        test.add(originator.saveStateToMemento());
        originator.setState("state 4");

        System.out.println("current state: " + originator.getState());
        originator.getStateFromMemento(test.get(0));
        System.out.println("first saved state: " + originator.getState());
        originator.getStateFromMemento(test.get(1));
        System.out.println("second saved state: " + originator.getState());
    }
}
