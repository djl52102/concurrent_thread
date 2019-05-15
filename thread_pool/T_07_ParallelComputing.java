package cn.ctyun.thread.thread_pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class T_07_ParallelComputing {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        getPrime(1,200000);
        long end=System.currentTimeMillis();
        System.out.println(end-start);

        MyTask t1 = new MyTask(1, 50000);
        MyTask t2 = new MyTask(50001, 80000);
        MyTask t3 = new MyTask(80001, 130000);
        MyTask t4 = new MyTask(130001, 200000);
        ExecutorService service= Executors.newFixedThreadPool(4);
        Future<List<Integer>> f1= service.submit(t1);
        Future<List<Integer>> f2 = service.submit(t2);
        Future<List<Integer>> f3 = service.submit(t3);
        Future<List<Integer>> f4 = service.submit(t4);

        long s = System.currentTimeMillis();
        try {
            f1.get();
            f2.get();
            f3.get();
            f4.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long e=System.currentTimeMillis();
        System.out.println(e-s);
    }


    static class MyTask implements Callable<List<Integer>>{

        private int start;

        private int end;

        public MyTask(int start,int end){
            this.start=start;
            this.end=end;
        }

        @Override
        public List<Integer> call() throws Exception {
            return getPrime(start,end);
        }
    }



    static boolean isPrime(int num){
        for(int i=2;i<=num/2;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    static List<Integer> getPrime(int start,int end){
        List<Integer> list=new ArrayList<>();
        for (int i=start;i<=end;i++){
            if(isPrime(i)){
                list.add(i);
            }
        }
        return list;
    }
}
