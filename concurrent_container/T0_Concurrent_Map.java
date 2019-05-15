package cn.ctyun.thread.concurrent_container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class T0_Concurrent_Map {
    //static


    public static void main(String[] args) {
        ConcurrentHashMap<String,String> map=new ConcurrentHashMap();
        //Hashtable<String,String> map=new Hashtable<>();
        Random random = new Random();
        Thread[] t=new Thread[100];
        CountDownLatch latch=new CountDownLatch(t.length);
        long start=System.currentTimeMillis();
        for(int i=0;i<100;i++){
            t[i]=new Thread(()->{
                for(int j=0;j<10000;j++){
                    map.put("a"+random.nextInt(100000),"a"+random.nextInt(100000));
                    latch.countDown();
                }
            });
        }
        Arrays.asList(t).forEach(th->th.start());
        try {
            latch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        Long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
