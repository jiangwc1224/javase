package com.jwc.juc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo001 {
	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i=0;i<30;i++) {
			es.execute(() ->{
				System.out.println(Thread.currentThread().getName());
			});
		}
		es.isShutdown();
	}
}
