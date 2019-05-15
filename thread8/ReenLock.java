package cn.ctyun.thread.thread8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenLock {

    private Lock lock=new ReentrantLock();

    void m1(){

        for (int i=0;i<100;i++){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"i");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReenLock reenLock = new ReenLock();
        new Thread(()->reenLock.m1(),"t1").start();
        new Thread(()->reenLock.m1(),"t2").start();
    }
}
