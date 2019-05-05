package cn.ctyun.thread.thread5;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class T {
    volatile AtomicInteger count=new AtomicInteger(0);
    /*synchronized*/ void m(){
        for (int i=0;i<10000;i++){
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        T t = new T();
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i=0;i<10;i++){
            threads.add(new Thread(()->t.m(),"Thread-"+i));
        }

        threads.forEach((o)->o.start());
        threads.forEach((o)-> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
