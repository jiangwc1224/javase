package com.jwc.juc.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledPoolDemo001 {
	public static void main(String[] args) {
		ScheduledExecutorService se = Executors.newSingleThreadScheduledExecutor();
		System.out.println(System.currentTimeMillis());

		// 延迟3秒
		for (int i = 0; i < 3; i++) {
			se.schedule(() -> {
				System.out.println(Thread.currentThread().getName());
				System.out.println(System.currentTimeMillis());
			}, 3, TimeUnit.SECONDS);
		}

		// 延迟3秒，间断2秒

		se.scheduleAtFixedRate(() -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println(System.currentTimeMillis());
		}, 3, 2, TimeUnit.SECONDS);

	}
}
