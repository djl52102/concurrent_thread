package cn.ctyun.thread.thread3;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

public class Account {
    private String name;
    private double balance;

    public synchronized void set(String name,Double balance){
        this.name=name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance=balance;
    }


    public synchronized Double get(String name){
        return this.balance;
    }


    public static void main(String[] args) {
        Account a = new Account();
        new Thread(()->a.set("张三",100.00)).start();
        System.out.println(a.get("张三"));
    }
}
