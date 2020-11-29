package java.com.jwc.juc.example;

/**
 * volatile
 *
 * @author jwc
 */
public class MyA1B2C3004 {
    enum ReadyToRun {T1, T2}

    ;

    private volatile static ReadyToRun readyToRun = ReadyToRun.T1;

    public static void main(String[] args) {
        char[] a = "ABCDEFG".toCharArray();
        char[] b = "1234567".toCharArray();

        new Thread(() -> {
            for (char c : a) {
                while (!readyToRun.equals(ReadyToRun.T1)) {
                }
                System.out.print(c);
                readyToRun = ReadyToRun.T2;
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : b) {
                while (!readyToRun.equals(ReadyToRun.T2)) {
                }
                System.out.print(c);
                readyToRun = ReadyToRun.T1;
            }
        }, "t2").start();
    }
}
