package sellTicketDemo;

public class Ticket implements Runnable {

    private int count = 100;
    Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + (101 - count) + "张票");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count--;
                } else {
                    System.out.println("车票已售罄");
                    System.exit(0);
                }
            }
        }

    }
}
