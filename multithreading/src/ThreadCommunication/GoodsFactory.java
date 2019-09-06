package ThreadCommunication;

public class GoodsFactory extends Thread {
    private Goods goods;

    public GoodsFactory(String name, Goods goods) {
        super(name);
        this.goods = goods;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (goods) {
                if (goods.getResidue() > 0) {//有库存
                    try {
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.print(Thread.currentThread().getName() + "生产商品");

                    try {
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(1000);
                            System.out.print(".");
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println();
                    goods.setResidue(200);

                    System.out.println("200个商品生产完毕");
                    goods.notifyAll();
                    try {
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }


    }
}
