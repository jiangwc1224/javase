package java.com.jwc.juc.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo001 {
	public static void main(String[] args) {
		ScheduledExecutorService se = Executors.newScheduledThreadPool(5);
		
		System.out.println(System.currentTimeMillis());
		
//		for (int i = 0; i < 10; i++) {
//			se.schedule(() ->{
//				System.out.println(Thread.currentThread().getName());
//				System.out.println(System.currentTimeMillis());
//			}, 2, TimeUnit.SECONDS);
//		}
		
		
		se.scheduleWithFixedDelay(() ->{
			System.out.println(Thread.currentThread().getName());
			System.out.println(System.currentTimeMillis());
		}, 500, 200, TimeUnit.MILLISECONDS);
	}
}
