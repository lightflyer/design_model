package DesignModel;


// 命令模式是一种数据驱动的设计模式,请求以命令的形式包裹在对象中,并传给调用对象.调用对象寻找可以处理命令的合适对象,并把命令传给相应对象处理.
// 主要解决:需要对行为进行记录、撤销或者重做、事务等处理时，降低耦合度.

// 例子:买卖股票

import java.util.ArrayList;
import java.util.List;

class Stock{
    private String name;
    private int quantity;

    public void buy(){
        System.out.println(this.toString() + " bought.");
    }

    public void sell(){
        System.out.println(this.toString() + " sold.");
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

interface Order{
    public void execute();
}

class BuyStock implements Order{
    private Stock stock;

    public BuyStock(Stock stock){
        this.stock = stock;

    }
    @Override
    public void execute() {
        this.stock.buy();
    }
}

class SellStock implements Order{
    private Stock stock;

    public SellStock(Stock stock){
        this.stock = stock;
    }

    @Override
    public void execute() {
        this.stock.sell();
    }
}

public class CommandModel {

    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList){
            order.execute();
        }

        orderList.clear();
    }

    public static void main(String[] args) {

        Stock stock = new Stock();

        BuyStock buyStockOrder = new BuyStock(stock);
        SellStock sellStockOrder = new SellStock(stock);

        CommandModel test = new CommandModel();
        test.takeOrder(buyStockOrder);
        test.takeOrder(sellStockOrder);

        test.placeOrders();
    }

}
