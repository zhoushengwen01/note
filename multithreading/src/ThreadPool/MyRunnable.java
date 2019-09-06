package ThreadPool;

public class MyRunnable implements Runnable {
    private Thread t;
    private String threadName;

    public MyRunnable(String threadName) {
        this.threadName = threadName;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + "  " + i);

        }


    }
}
