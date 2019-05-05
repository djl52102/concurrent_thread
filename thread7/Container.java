package cn.ctyun.thread.thread7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Container {
    private volatile List list=new ArrayList<>();

    public void add(Object o){
        list.add(o);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        Container c = new Container();

        CountDownLatch latch=new CountDownLatch(1);

        new Thread(()->{
            if(c.size()!=5){
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2线程结束");
        },"t2").start();

        new Thread(()->{
            for (int i=0;i<10;i++){
                c.add(i);
                System.out.println(i);
                if(c.size()==5){
                    latch.countDown();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();


    }
}
