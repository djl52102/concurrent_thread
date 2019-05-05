package cn.ctyun.thread.demo2;

public class T implements Runnable{

    private int count=10;

    //private Object o=new Object();

    /*public void m(){
        synchronized (o){
            count--;
            System.out.println(Thread.currentThread().getName()+"count--"+count);
        }
    }*/

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+"count--"+count);
    }

    public static void main(String[] args) {
        //Thread thread = new Thread(new T());
        T t = new T();
        for (int i=0;i<5;i++){
            new Thread(t,"Thread"+i).start();
        }

    }
}
