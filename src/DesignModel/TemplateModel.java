package DesignModel;

// 在模板模式中,一个抽象类（有一个主方法）,公开定义了执行它方法的方式/模板.它的子类可以俺需要重写方法实现,但调用将以抽象类中定义的方式进行.
// 主要解决:一些方法通用,却在每一个子类都重写了这一方面

// 例子: 游戏引擎

abstract class Game{
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //主方法/模板 方法被设置成final,这样不会被重写
    public final void play(){
        initialize();
        startPlay();
        endPlay();
    }
}

class Cricket extends Game{

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game started! Enjoy Game.");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game finished.");
    }
}

class Football extends Game{

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game started! Enjoy Game.");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game finished.");
    }
}

public class TemplateModel {

    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();

        System.out.println();

        game = new Football();
        game.play();
    }


}
