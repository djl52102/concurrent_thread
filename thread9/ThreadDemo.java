package cn.ctyun.thread.thread9;

import java.util.concurrent.TimeUnit;

public class ThreadDemo {
    static class Person{
        String name="zhangsan";
    }

    static Person p=new Person();

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name="wangwu";
        }).start();

    }
}
