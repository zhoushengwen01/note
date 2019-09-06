package ThreadCommunication;

public class ThreadCommunicationTest {
    public static void main(String[] args) {
        Goods goods = new Goods(500);



        GoodsFactory factory = new GoodsFactory("商品工厂", goods);
        Customer customer1 = new Customer("张三", goods,10);
        Customer customer2 = new Customer("李四", goods,20);
        Customer customer3 = new Customer("王五", goods,30);


        customer1.start();
        customer2.start();
        customer3.start();
        factory.start();


    }
}
