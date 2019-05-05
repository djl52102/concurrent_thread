package cn.ctyun.thread.demo1;

public class Demo1 extends Thread {
    @Override
    public void run() {
        while (!interrupted())
        System.out.println(getName()+"线程执行了");
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        Demo1 demo2 = new Demo1();

        //demo1.setDaemon(true);
        //demo2.setDaemon(true);

        demo1.start();
        demo2.start();

        demo1.interrupt();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
