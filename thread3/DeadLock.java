package cn.ctyun.thread.thread3;

public class DeadLock {

    public synchronized void m1(){
        m2();
        while (true){
            System.out.println(Thread.currentThread().getName()+"run");
        }
    }

    public synchronized void m2(){
        m1();
        while (true){
            System.out.println(Thread.currentThread().getName()+"run");
        }
    }

    public static void main(String[] args) {
        DeadLock d= new DeadLock();
        new Thread(()->d.m1()).start();
        new Thread(()->d.m2()).start();
    }
}
