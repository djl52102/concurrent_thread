package cn.ctyun.thread.thread6;

import java.util.concurrent.TimeUnit;

public class T {
    private Object o=new Object();

    public void m(){
        synchronized (o){
            while (true){
                System.out.println(Thread.currentThread().getName()+"running");
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(()->t.m()).start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //t.o=new Object();
        new Thread(()->t.m()).start();
    }
}
