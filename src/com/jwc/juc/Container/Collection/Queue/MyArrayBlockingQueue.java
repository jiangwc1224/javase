package com.jwc.juc.Container.Collection.Queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyArrayBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(5);
        for (int i = 0; i < 10; i++) {
            boolean isSuccess = blockingQueue.offer(String.valueOf(i));
            System.out.println(isSuccess);
        }
    }
}
