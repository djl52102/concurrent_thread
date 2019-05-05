package cn.ctyun.thread.thread3;

public class R {

    int count;

    public synchronized void m1(){
        while(true){
            count++;
            System.out.println(Thread.currentThread().getName()+"count="+count);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count==5){
                count=1/0;
            }
        }
    }

    public static void main(String[] args) {
        R r = new R();
        new Thread(()->r.m1(),"t1").start();
        new Thread(()->r.m1(),"t2").start();
    }
}
