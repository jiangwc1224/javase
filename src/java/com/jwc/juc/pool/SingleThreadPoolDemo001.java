package java.com.jwc.juc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolDemo001 {
	public static void main(String[] args) {
		ExecutorService se = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 30; i++) {
			se.execute(() ->{
				System.out.println(Thread.currentThread().getName() + "~~~" + Thread.currentThread().getId());
			});
		}
		se.shutdown();
	}
}
