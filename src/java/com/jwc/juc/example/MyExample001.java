package java.com.jwc.juc.example;

import java.util.LinkedList;


/**
 * 有一个容器最多能装20个物品，有两个生产者，每次生产25个，有10个消费者，每次消费5个，生产者达到容器满则通知消费者，消费者消费使得容器到0，则通知生产者生产
 * 方法：wait(), notifyAll()
 *
 * @param <T>
 * @author Administrator
 */
public class MyExample001<T> {
    final private LinkedList<T> oList = new LinkedList<T>();
    final private int maxCount = 10;

    private synchronized void put(T o) {
        while (oList.size() == maxCount) {
            try {
                System.out.println("容器慢了：" + oList.size());
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        oList.add(o);
        System.out.println("容器现有：" + oList.size());
        this.notifyAll();
    }

    private synchronized T get() {
        T o = null;

        while (oList.size() == 0) {
            try {
                System.out.println("容器空了：" + oList.size());
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        o = oList.removeFirst();
        System.out.println("容器还剩：" + oList.size());
        this.notifyAll();
        return o;
    }

    public static void main(String[] args) {
        MyExample001<String> me = new MyExample001<String>();

        //生产者
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    me.put(Thread.currentThread().getName() + " " + j);
                }
            }, "ProducerThread" + i).start();
        }

        //消费者
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println("我拿的是" + me.get() + "生产的东西");
                }
            }, "ConsumerThread" + i).start();
        }
    }
}
