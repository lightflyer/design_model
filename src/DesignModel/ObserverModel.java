package DesignModel;

// 当对象存在一对多关系时,则使用观察者模式;当一个对象变化时,其他依赖对象都会收到通知,并且随着变化
// 主要解决: 一个对象状态改变给其他对象通知的问题,而且要考虑到易用和高耦合,保证高度的协作.

// 例子:观察者模式(Subject、Observer、Client)

import java.util.ArrayList;
import java.util.List;

class Subject{
    private List<Observer> observers;
    private int state;

    public Subject(){
        this.observers = new ArrayList<Observer>();
    }

    public int getState(){
        return this.state;
    }

    public void setState(int state){
        this.state = state;
        this.notifyAllObservers();
    }

    public void attach(Observer observer){
        this.observers.add(observer);
    }

    public void notifyAllObservers() {
        for(Observer observer: observers){
            observer.update();
        }
    }

}

abstract class Observer{
    // 其实本例中Observer 可以写成模板模式
    protected Subject subject;
    public abstract void update();

}

class BinaryObserver extends Observer{
    public BinaryObserver(Subject subject) {
        this.subject =subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(this.subject.getState()));
    }
}

class OctalObserver extends Observer{
    public OctalObserver(Subject subject) {
        this.subject =subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(this.subject.getState()));
    }
}

class HexObserver extends Observer{
    public HexObserver(Subject subject) {
        this.subject =subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toOctalString(this.subject.getState()).toUpperCase());
    }
}


public class ObserverModel{
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);

        System.out.println();

        System.out.println("Second state change: 10");
        subject.setState(10);
    }

}


