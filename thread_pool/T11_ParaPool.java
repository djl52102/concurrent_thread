package cn.ctyun.thread.thread_pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class T11_ParaPool {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        Random r = new Random();
        int i = r.nextInt(1000000);
        list.add(1000000+i);
        long start=System.currentTimeMillis();
        list.forEach(v->isPrime(v));
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        long start2=System.currentTimeMillis();
        list.parallelStream().forEach(T11_ParaPool::isPrime);
        long end2=System.currentTimeMillis();
        System.out.println(end2-start2);

    }

   static boolean isPrime(Integer num){
        for(int i=0;i<num/2;i++){
            if(num%2==0){return false;}
        }
        return true;
    }
}
