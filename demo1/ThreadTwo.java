package cn.ctyun.thread.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadTwo implements Callable<Integer> {

    public static void main(String[] args) throws Exception {
        /*ThreadTwo threadTwo = new ThreadTwo();
        FutureTask<Integer> task = new FutureTask<>(threadTwo);
        Thread thread = new Thread(task);
        thread.run();
        Integer integer = task.get();
        System.out.println(integer);*/
        Executor threadPool= Executors.newFixedThreadPool(10);
        for(int i=0;i<100;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"正在执行");
                }
            });
        }

    }


    @Override
    public Integer call() throws Exception {
        System.out.println("正在紧张计算中");
        Thread.sleep(3000);
        return 1;
    }
}
