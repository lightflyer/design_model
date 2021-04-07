package DesignModel;

// 中介者模式用来降低多个对象和类之间的通信复杂度
// 主要解决: 对象与对象之间存在大量的关联关系,这样势必会导致系统结构变得复杂

// 实例:多用户聊天室

import java.util.Date;

class ChatRoom{
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString() + "[" + user.getName() + "]:" + message);
    }
}

class User{
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this, message);
    }
}

public class MediatorModel {
    public static void main(String[] args) {
        User hello  = new User("hello");
        User world = new User("world");

        hello.sendMessage("hello, world!");
        world.sendMessage("python have fun");
    }
}
