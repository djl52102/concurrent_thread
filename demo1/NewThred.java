package cn.ctyun.thread.demo1;

public class NewThred implements Runnable {
    @Override
    public void run() {
        System.out.println("线程1执行");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new NewThred());
        thread.start();
    }
}
