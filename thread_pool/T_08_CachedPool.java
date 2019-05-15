package cn.ctyun.thread.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T_08_CachedPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(service);
        service.execute(()->{
            for (int i=0;i<2;i++){
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        });
        System.out.println(service);
        TimeUnit.SECONDS.sleep(80);
        System.out.println(service);
    }
}
