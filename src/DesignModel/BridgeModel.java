package DesignModel;

// 桥接模式用于把抽象化与现实接口,使二者独立变化
// 例子:BridgeModel作为桥

interface DrawAPI{
    public void drawCircle(int radius, int x, int y);
}

class RedCircle implements DrawAPI{

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x:" + x + ", y:" + y + "]");
    }
}

class GreenCircle implements DrawAPI{

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x:" + x + ", y:" + y +"]");
    }
}

public class BridgeModel {

    protected DrawAPI drawAPI;
    private int x, y, radius;

    public BridgeModel(int x, int y, int radius, DrawAPI drawAPI){
        this.drawAPI = drawAPI;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw(){
        this.drawAPI.drawCircle(this.radius, this.x, this.y);
    }

    public static void main(String[] args) {
        BridgeModel redCircle = new BridgeModel(100, 199, 10, new RedCircle());
        BridgeModel greenCircle = new BridgeModel(10, 233, 23, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
