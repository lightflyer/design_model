package DesignModel;

// 单例模式是一种常用的模式,保证在运行过程中,该单例对象只有一个实例存在


import java.util.Vector;

class Singleton{
    private static Singleton instance = null;

    private Singleton(){
        System.out.println("init singleton");
    }

    // 这种方式没有考虑线程的安全,适用于单线程
    public static Singleton getInstanceSingleThread(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public Object readResolve(){
        return instance;
    }

    //添加 synchronized 保证线程安全
    public static synchronized Singleton getInstanceSecurity1(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    //synchronized 锁住的是对象, 在方法上调用导致每次都要对对象上锁，事实上,只需要在第一次创建时加锁便可
    public static Singleton getInstanceSecurity2(){
        if (instance == null){
            syncInit();
        }
        return instance;
    }

    public static synchronized void syncInit(){
        if (instance == null){
            instance = new Singleton();
        }
    }

    //利用jvm内部机制保证一个类被加载时,类加载过程是线程互斥的,当我们第一次调用getInstance时, jvm能帮我们确保instance只创建一次
    private static class SingleFactory{
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstanceClass(){
        return SingleFactory.singleton;
    }

    //单例对象的更新,影子实例
    private Vector properties = null;

    public Vector getProperties(){
        return properties;
    }

    public void updateProperties(){
        Singleton shadow = new Singleton();
        properties = shadow.getProperties();
    }

}

public class SingleModel {
    public static void main(String[] args) {

    }

}
