package DesignModel;

// 外观模式解决类与类之间的依赖关系,降低类与类之间的耦合度;向现有的系统添加一个接口，来隐藏系统的复杂性
// 例子:创建一个Shape接口及其子类;通过外观类FacadeModel来代表用户进行调用.

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Shape:Square");
    }
}


public class FacadeModel {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public FacadeModel(){
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawRectangle(){
        rectangle.draw();
    }

    public void drawSquare(){
        square.draw();
    }


    public static void main(String[] args) {
        FacadeModel facadeModel = new FacadeModel();

        facadeModel.drawCircle();
        facadeModel.drawRectangle();
        facadeModel.drawSquare();
    }

}
