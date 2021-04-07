package DesignModel;

// 装饰器模式允许像一个现有的对象动态添加新的功能，同时又不改变其结构。

interface Shape{
    public void draw();
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Shape:Rectangle");
    }
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Shape:Circle");
    }
}

abstract class ShapeDecorator implements Shape{
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}

class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        super.draw();
        this.setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color:Red");
    }
}
public class DecoratorModel {
    public static void main(String[] args) {
        Shape circle = new Circle();
        ShapeDecorator redCirCle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border:");
        circle.draw();

        System.out.println("Circle with red border:");
        redCirCle.draw();

        System.out.println("Rectangle with red border:");
        redRectangle.draw();


    }
}
