package DesignModel;

// 状态模式中,类的行为是基于它的状态改变的.在状态模式中,我们创建表示各种状态的对象和一个行为随着状态对象改变而改变的context对象.
// 主要解决: 对象的行为依赖于它的属性(状态),并且可以根据它的状态改变而改变它的相关行为.

// 例子

import javax.naming.Context;

interface State{
    public void doAction(StateModel context);
}

class StartState implements State{

    @Override
    public void doAction(StateModel context) {
        System.out.println("Do start action.");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Start State";
    }
}

class StopState implements State{

    @Override
    public void doAction(StateModel context) {
        System.out.println("Do stop action.");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Stop State";
    }
}

public class StateModel {

    private State state;

    public StateModel(){
        state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static void main(String[] args) {
        StateModel context = new StateModel();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }
}
