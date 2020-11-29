package java.com.jwc.juc.example;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * BlockingDeque
 *
 * @author jwc
 */
public class MyA1B2C3005 {
    public static void main(String[] args) throws InterruptedException {
        char[] a = "ABCDEFG".toCharArray();
        char[] b = "1234567".toCharArray();

        BlockingDeque<String> bDeque1 = new LinkedBlockingDeque<String>(1);
        BlockingDeque<String> bDeque2 = new LinkedBlockingDeque<String>(1);

        new Thread(() -> {
            for (char c : a) {
                System.out.print(c);
                try {
                    bDeque1.put("OK");
                    bDeque2.take();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : b) {
                try {
                    bDeque1.take();
                    System.out.print(c);
                    bDeque2.put("OK");
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        }, "t1").start();
    }
}
