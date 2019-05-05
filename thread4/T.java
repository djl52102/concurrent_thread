package cn.ctyun.thread.thread4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class T {

    /*volatile*/ AtomicBoolean flag =new AtomicBoolean(true);

    public void m(){
        System.out.println("m start");
        while (flag.get()==true){

        }
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(()->t.m()).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag.set(false);
    }
}
