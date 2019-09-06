package sellTicketDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket_lock implements Runnable {

    private int count = 100;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
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
            lock.unlock();
        }

    }
}
