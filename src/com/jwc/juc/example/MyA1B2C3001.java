package com.jwc.juc.example;

import java.util.concurrent.locks.LockSupport;

/**
 * lockSupport实现
 *
 * @author jwc
 */
public class MyA1B2C3001 {
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        char[] a = "ABCDEFG".toCharArray();
        char[] b = "1234567".toCharArray();

        t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < a.length; i++) {
                    System.out.print(a[i]);
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        };

        t2 = new Thread() {
            @Override
            public void run() {
                for (int j = 0; j < b.length; j++) {
                    LockSupport.park();
                    System.out.print(b[j]);
                    LockSupport.unpark(t1);

                }
            }
        };

        t1.start();
        t2.start();

    }
}
