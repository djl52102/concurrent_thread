package cn.ctyun.thread.thread3;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

public class T {
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+"m1方法开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"m1方法结束");
    }

    public void m2(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"m2方法执行");
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(()->t.m1(),"t1").start();
        new Thread(()->t.m2(),"t2").start();
    }
}
