package DesignModel;

// 建造者模式是讲各种产品集中起来进行管理，用来创建复合对象
// 以MailSender和SmsSender作为例子

import java.util.ArrayList;
import java.util.List;




public class BuilderModel {

    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count){
        for(int i = 0; i < count; i++){
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count){
        for(int i = 0; i < count; i++){
            list.add(new SmsSender());
        }
    }

    public List<Sender> getSenders(){
        return list;
    }

    public static void main(String[] args) {
        BuilderModel hello = new BuilderModel();

        hello.produceMailSender(10);
        hello.produceSmsSender(10);

        for(Sender sender: hello.getSenders()){
            sender.send();
        }
    }

}
