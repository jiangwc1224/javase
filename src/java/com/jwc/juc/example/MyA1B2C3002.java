package java.com.jwc.juc.example;

import java.util.concurrent.CountDownLatch;

/**
 * synchronized wait() notify()
 * 
 * @author jwc
 *
 */
public class MyA1B2C3002 {

	// 自旋控制先后顺序
//	private static volatile boolean flag = true;
	// CountDownLatch控制先后顺序
	private static CountDownLatch latch = new CountDownLatch(1);

	public static void main(String[] args) {
		char[] a = "ABCDEFG".toCharArray();
		char[] b = "1234567".toCharArray();
		Object o = new Object();

		new Thread(() -> {
			try {
				latch.await();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			synchronized (o) {
//				while(flag) {
//					try {
//						o.wait();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
				
				for (char c : b) {
					System.out.print(c);
					o.notify();
					try {
						o.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				o.notify();
			}
		}).start();
		
		new Thread(() -> {
			synchronized (o) {
				for (char c : a) {
					System.out.print(c);
//					flag= false;
					latch.countDown();
					o.notify();
					try {
						o.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				o.notify();
			}
		}).start();

		

	}
}
