package cn.ctyun.thread.concurrent_container;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class T1_Concurrent_Quene {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queues = new ConcurrentLinkedQueue<>();
        for(int i=0;i<10;i++){
            queues.offer(i);
        }
        System.out.println(queues);
        System.out.println(queues.size());

        System.out.println(queues.poll());
        System.out.println(queues.size());

        System.out.println(queues.peek());
        System.out.println(queues.size());
    }
}
