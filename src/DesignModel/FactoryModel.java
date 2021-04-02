package DesignModel;

// 普通工厂模式，建立一个工厂类，对实现了同一接口的一些累进行实例的创建
// 举一个发送邮件和短信的例子

interface Sender{
    public void send();
}

class MailSender implements Sender{

    @Override
    public void send() {
        System.out.println("this is mail sender");
    }
}

class SmsSender implements Sender{

    @Override
    public void send() {
        System.out.println("this is sms sender");
    }
}

class SendFactory{

    // single factory
    public Sender produce(String type){
        if ("mail".equals(type)){
            return new MailSender();
        }else if ("sms".equals(type)){
            return new SmsSender();
        }else {
            System.out.println("pls input regular type");
            return null;
        }
    }

    // multiple factory
    public MailSender produceMailSender(){
        return new MailSender();
    }

    public SmsSender produceSmsSender(){
        return new SmsSender();
    }

    // static factory
    public static MailSender produceMailSenderByStatic(){
        return new MailSender();
    }

    public static SmsSender produceSmsSenderByStatic(){
        return new SmsSender();
    }
}

// 抽象工厂模式;
// 普通工厂模式的创建也是依赖于工厂类的创建;违背了闭包原则;所以,需要用到抽象工厂模式，这样一旦需要增加新的功能，直接增加新的工厂类就行了

interface Provider{
    public Sender produce();
}

class SendSmsFactory implements Provider{

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}

class SendMailFactory implements Provider{

    @Override
    public Sender produce() {
        return new MailSender();
    }
}



public class FactoryModel {

    public void testSingleFactory(){
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.send();
    }

    public void testMultipleFactory(){
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceMailSender();
        sender.send();
    }

    public void testStaticFactory(){
        Sender sender = SendFactory.produceSmsSenderByStatic();
        sender.send();
        sender = SendFactory.produceMailSenderByStatic();
        sender.send();
    }

    public void testAbstractFactory(){
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.send();

    }

    public static void main(String[] args) {
        System.out.println("hello world");
        FactoryModel hello = new FactoryModel();

        System.out.println("this is single factory demo run:");
        hello.testSingleFactory();
        System.out.println("this is multiple factory demo run:");
        hello.testMultipleFactory();
        System.out.println("this is static factory demo run:");
        hello.testStaticFactory();
        System.out.println("this is abstract factory demo run:");
        hello.testAbstractFactory();
    }
}
