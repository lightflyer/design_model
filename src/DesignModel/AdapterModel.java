package DesignModel;


// 适配器模式将某个类的接口转换成客户端期望的另一个接口表示;

class Source{
    public void doSomething(){
        System.out.println("Doing something!");
    }
}

interface  Target{
    public void doSomething();
    public void saySomething();
}


class Wrapper implements Target{
    private Source source;

    public Wrapper(Source source){
        super();
        this.source = source;
    }

    @Override
    public void doSomething() {
        source.doSomething();
    }

    @Override
    public void saySomething() {
        System.out.println("Say Something");

    }
}
public class AdapterModel extends Source implements Target{



    @Override
    public void saySomething() {
        System.out.println("Say something!");
    }

    public static void main(String[] args) {

        //类的适配器模式
//        Target target = new AdapterModel();
//        target.doSomething();
//        target.saySomething();
        //对象的适配器模式
        Source source = new Source();
        Target target = new Wrapper(source);
        target.doSomething();
        target.saySomething();

    }
}
