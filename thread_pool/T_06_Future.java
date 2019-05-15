package cn.ctyun.thread.thread_pool;

import java.util.concurrent.*;

public class T_06_Future {
    public static void main(String[] args) {
        FutureTask<Integer> task=new FutureTask<>(()->{
            TimeUnit.SECONDS.sleep(5);
            return 1000;
        });
        new Thread(task).start();
        try {
            System.out.println(task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }


        ExecutorService service= Executors.newFixedThreadPool(5);
        Future<Integer> future=service.submit(()->{
            TimeUnit.SECONDS.sleep(5);
            return 1;
        });
        /*try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        System.out.println(future.isDone());
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(future.isDone());
    }
}
