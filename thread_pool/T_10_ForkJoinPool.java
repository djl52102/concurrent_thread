package cn.ctyun.thread.thread_pool;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class T_10_ForkJoinPool {

    static int[] nums=new int[1000000];

    static final int MAX_NUM=50000;

    static Random r=new Random();


    static class Task extends RecursiveTask<Long>{

        int start;
        int end;

        Task(int s,int e){
            start=s;
            end=e;
        }

        @Override
        protected Long compute() {
            long sum=0L;
            if((end-start)<=MAX_NUM){
                for (int i=start;i<end;i++){
                    sum+=nums[i];
                }
                return sum;
            }else{
                int middle=start+(end-start)/2;
                Task task1 = new Task(start, middle);
                Task task2 = new Task(middle, end);
                task1.fork();
                task2.fork();
                return task1.join()+ task1.join();
            }
        }
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        for(int i=0;i<nums.length;i++){
            nums[i]=r.nextInt(100);
        }
        System.out.println(Arrays.stream(nums).sum());

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> submit = forkJoinPool.submit(new Task(0, nums.length));
        System.out.println(submit.get());
        //System.in.read();
    }
}
