package DesignModel;


// 代理模式，一个类代表另一个类的功能。代理模式种，我们创建具有先有对象的对象，以便向外界提供功能接口
// 例子:创建image 接口实现 Image接口的实体类. ProxyImage 作为代理类，减少RealImage 对象加载的内存占用

interface Image{
    public void display();
}

class RealImage implements Image{

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        this.loadFromDisk(fileName);
    }
    @Override
    public void display() {
        System.out.println("Displaying " + fileName);

    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}

class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(this.fileName);
        }

        realImage.display();
    }
}


public class ProxyModel {
    public static void main(String[] args) {
        Image image = new ProxyImage("hello_world.jpg");

        //图像从磁盘加载
        image.display();
        System.out.println();

        //图像不需要从磁盘加载
        image.display();
    }
}
