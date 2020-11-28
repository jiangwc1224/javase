package java.com.jwc.juc.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock Condition
 * @author jwc
 *
 */
public class MyA1B2C3003 {
	public static void main(String[] args) {
		char[] a = "ABCDEFG".toCharArray();
		char[] b = "1234567".toCharArray();
		
		ReentrantLock lock = new ReentrantLock();
		Condition condition1  = lock.newCondition();
		Condition condition2 = lock.newCondition();
		
		new Thread(()->{
			try {
				lock.lock();
				for (char c : a) {
					System.out.print(c);
					condition2.signal();
					try {
						condition1.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
			
		}).start();
		
		new Thread(()->{
			try {
				lock.lock();
				for (char c : b) {
					System.out.print(c);
					condition1.signal();
					try {
						condition2.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
			
		}).start();
	}
}
