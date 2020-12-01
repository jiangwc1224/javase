package com.jwc.juc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixThreadPoolDemo001 {
	public static void main(String[] args) {
		ExecutorService se = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 30; i++) {
			se.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"~~~"+Thread.currentThread().getId());
				}
				
			});
		}
		se.shutdown();
	}
}
