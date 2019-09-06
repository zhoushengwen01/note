package ThreadCommunication;

public class Customer extends Thread {
    private Goods goods;
    private int reaction;//反应速度


    public Customer(String name, Goods goods, int reaction) {
        super(name);
        this.reaction = reaction;
        this.goods = goods;
    }


    @Override
    public void run() {
        while (true) {


            synchronized (goods) {
                if (reaction > 0) {
                    goods.notifyAll();
                    reaction--;
                    try {
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {


                    if (!(goods.getResidue() > 0)) {  //无库存
                        System.out.println("等待商品生产");
                        try {
                            goods.notifyAll();
                            goods.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        long residue = goods.getResidue();
                        System.out.println(Thread.currentThread().getName() + "抢购了商品(剩余:" + (--residue) + "个)");
                        goods.setResidue(residue);
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
}
