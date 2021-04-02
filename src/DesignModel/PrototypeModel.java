package DesignModel;


// 原型模式是创建型的模式，该模式的思想是将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象。java中，复制对象是通过clone()实现

import java.io.*;

public class PrototypeModel implements Cloneable, Serializable {

    // 浅复制:将一个对象复制后,基本数据类型都会重新创建,而引用类型,指向的还是原对象所指向的.
    public Object clone() throws CloneNotSupportedException{
        PrototypeModel proto = (PrototypeModel) super.clone();
        return proto;
    }

    // 深复制:将一个对象复制后,不论基本数据类型还是引用类型,都是重新创建的.简单来说,深复制进行了完全彻底的复制,而浅复制不彻底.

    // 要实现深复制，需要采用流的形式读入当前对象的二进制输入,再写出二进制数据对应的对象

    private static final long serialVersionUID =1L;
    private String string;

    private SerializableObject obj;

    public Object deepClone() throws IOException, ClassNotFoundException{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public String getString(){
        return string;
    }

    public void setString(String string){
        this.string = string;
    }

    public SerializableObject getObj(){
        return obj;
    }

    public void setObj(){
        this.obj = obj;
    }

    public static void main(String[] args) {
        PrototypeModel hello = new PrototypeModel();
        hello.setString("hello world");

        try {
            PrototypeModel shallowClone = (PrototypeModel) hello.clone();

            PrototypeModel deepClone = (PrototypeModel) hello.deepClone();

            hello.setString("hello Prototype Model");
            System.out.println("shallow clone demo run:" + shallowClone.getString());
            System.out.println("deep clone demo run:" + deepClone.getString());


        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class SerializableObject implements Serializable{
    private static final long serialVersionUID = 1;
}


