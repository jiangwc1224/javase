package java.com.jwc.juc.Container.Collection.Queue;

import java.util.PriorityQueue;

public class MyPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<String>();

        q.add("b");
        q.add("y");
        q.add("3");
        q.add("e");
        q.add("1");
        q.add("a");
        q.add("9");
        q.add("k");

        int count = q.size();

        for (int i = 0; i < count; i++) {
            System.out.println(q.poll());
        }
    }
}
