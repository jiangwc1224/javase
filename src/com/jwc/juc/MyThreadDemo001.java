package com.jwc.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class MyThreadDemo001 {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.start();

        Thread t2 = new Thread(new MyRun());
        t2.start();

        Thread t3 = new Thread(new FutureTask<>(new MyCall()));
        t3.start();

        new Thread(() -> {
            System.out.println("lambda表达式起线程");
        }).start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("匿名内部类起线程");
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> {
            System.out.println("线程池起线程");
        });
        service.shutdown();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("继承Thread类起线程");
        }
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("实现Runnable接口实起线程");
        }
    }

    static class MyCall implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            System.out.println("实现Callable接口实起线程");
            return true;
        }
    }

}
