package cn.ctyun.thread.concurrent_container;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class T2_Blocking_Queue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queues = new LinkedBlockingDeque<>();

       new Thread(()->{
           for(int i=0;i<100;i++){
               try {
                   queues.put(i);
                   TimeUnit.SECONDS.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }).start();


       for(int i=0;i<5;i++){
           new Thread(()->{
               for(;;){
                   try {
                       System.out.println(Thread.currentThread().getName()+"正在消费"+queues.take());
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           },"c"+i).start();
       }

    }
}
