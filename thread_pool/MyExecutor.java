package cn.ctyun.thread.thread_pool;

import java.util.concurrent.Executor;

public class MyExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }

    public static void main(String[] args) {
       new MyExecutor().execute(()-> System.out.println("正在调用任务"));
    }
}
