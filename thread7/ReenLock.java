package cn.ctyun.thread.thread7;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenLock {
    private Lock lock = new ReentrantLock();

    void m1(){
            lock.lock();
            try {
                for(int i=0;i<10;i++){
                TimeUnit.SECONDS.sleep(1);
                    System.out.println(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
    }

    void m2(){
        boolean locked=false;
        try {
            boolean b = lock.tryLock(5,TimeUnit.SECONDS);
            System.out.println("m2 ....."+b);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(locked) {lock.unlock();};
        }

    }

    public static void main(String[] args) {
        ReenLock reenLock = new ReenLock();
        new Thread(()->reenLock.m1()).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->reenLock.m2()).start();
    }
}
