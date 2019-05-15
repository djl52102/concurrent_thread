package cn.ctyun.thread.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T_05_Thread_Pool {

    static ExecutorService service= Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        for(int i=0;i<6;i++){
            service.execute(()->{
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println(service);
        service.shutdown();
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);

    }
}
