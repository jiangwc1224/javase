package java.com.jwc.juc.example;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * TransferQueue
 * @author jwc
 *
 */
public class MyA1B2C3006 {	
	public static void main(String[] args) {
		char[] a = "ABCDEFG".toCharArray();
		char[] b = "1234567".toCharArray();
		
		TransferQueue<Character> tQueue = new LinkedTransferQueue<>();
		
		new Thread(()->{
			for (char c : a) {
				try {
					tQueue.transfer(c);
					System.out.print(tQueue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"t1").start();
		
		new Thread(()->{
			for (char c : b) {
				try {
					System.out.print(tQueue.take());
					tQueue.transfer(c);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"t2").start();
	}
}
