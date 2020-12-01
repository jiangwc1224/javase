package com.jwc.juc.Container.Map;


import com.jwc.MyUtil.Constants;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


public class MyConcurrentHashMap {
    static ConcurrentHashMap<UUID, UUID> m = new ConcurrentHashMap<UUID, UUID>();

    static int count = Constants.COUNT;
    static int threadCount = Constants.THREAD_COUNT;

    static UUID[] keys = new UUID[count];
    static UUID[] values = new UUID[count];

    static {
        for (int i = 0; i < count; i++) {
            keys[i] = UUID.randomUUID();
            values[i] = UUID.randomUUID();
        }
    }

    static class MyThread extends Thread {
        int startCount;
        int gap = count / threadCount;


        public MyThread(int startCount) {
            this.startCount = startCount;
        }

        @Override
        public void run() {
            for (int i = startCount; i < startCount + gap; i++) {
                m.put(keys[i], values[i]);
            }
        }
    }

    public static void main(String[] args) {

        // 存数据
        // 开始时间
        long starttime = System.currentTimeMillis();

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(i * (count / threadCount));
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // 结束时间
        long endtime = System.currentTimeMillis();
        // 打印处理时间
        System.out.println("存数据量" + m.size());
        System.out.println("存数据时间" + String.valueOf(endtime - starttime));

        //取数据
        // 开始时间
        starttime = System.currentTimeMillis();

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000000; j++) {
                    m.get(keys[10]);
                }
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // 结束时间
        endtime = System.currentTimeMillis();
        // 打印处理时间
        System.out.println("取数据时间" + String.valueOf(endtime - starttime));
    }

}


