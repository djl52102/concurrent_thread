package cn.ctyun.thread.thread_pool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T_09_NetworkPool {
    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newWorkStealingPool();
        System.out.println(Runtime.getRuntime().availableProcessors());
        service.execute(new Task(1000));
        service.execute(new Task(2000));
        service.execute(new Task(2000));
        service.execute(new Task(2000));
        service.execute(new Task(2000));
        System.in.read();
    }


    static class Task implements Runnable{
        private int time;

        Task(int time){
            this.time=time;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
