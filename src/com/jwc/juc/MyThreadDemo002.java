package com.jwc.juc;

import java.util.concurrent.locks.ReentrantLock;

public class MyThreadDemo002 {
    public static void main(String[] args) {
        int count = 0;
        ReentrantLock lo = new ReentrantLock();
        lo.lock();

        count++;
        lo.unlock();
    }
}
