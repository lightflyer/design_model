package DesignModel;

// 责任链模式为请求创建了一个接受者对象的链,对请求的发送者和接受者进行解耦
// 主要解决:客户只需要将请求发送到指责脸上即可,无须关心请求的处理细节和请求的传递
// 如何解决:拦截的类都实行统一接口

// 例子:不同级别日志类

abstract class  AbstractLogger{
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    protected int level;

    protected AbstractLogger nextLogger;

    public AbstractLogger(int level){
        this.level = level;
    }

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    abstract protected void write(String message);

    public void logMessage(int level, String message){
        if(this.level <= level){
            write(message);
            return;
        }
        if (this.nextLogger != null){
            this.nextLogger.logMessage(level, message);

        }
    }
}

class ConsoleLogger extends AbstractLogger{


    public ConsoleLogger(int level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}

class ErrorLogger extends AbstractLogger{


    public ErrorLogger(int level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}

class FileLogger extends AbstractLogger{

    public FileLogger(int level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}

public class ChainOfResponsibilityModel {

    public static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "this is an information");
        loggerChain.logMessage(AbstractLogger.DEBUG, "this is a debug information");
        loggerChain.logMessage(AbstractLogger.ERROR, "this is an error information");
    }
}
