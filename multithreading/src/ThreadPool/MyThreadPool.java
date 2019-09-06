package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {

	private static MyThreadPool myThreadPool;
	ExecutorService service;

	private MyThreadPool() {
		if (service == null) {
			service = Executors.newFixedThreadPool(1);
		}
	}

	public static MyThreadPool getMyThreadPool() {
		if (myThreadPool == null) {
			myThreadPool = new MyThreadPool();
		}
		return myThreadPool;
	}

	public void excute() {
		MyRunnable myRunable = new MyRunnable("线程测试");
		service.submit(myRunable);
	}

}
