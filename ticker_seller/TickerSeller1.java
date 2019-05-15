package cn.ctyun.thread.ticker_seller;

import java.util.ArrayList;
import java.util.List;

public class TickerSeller1 {
    private static List<String> tickets=new ArrayList();

    static{
        for(int i=0;i<1000;i++){
            tickets.add("票编号"+i);
        }
    }

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        for(int i=0;i<10;i++){
            new Thread(()->{
                synchronized (tickets){
                    while (tickets.size()>0){
                        System.out.println("销售了--"+tickets.remove(0));
                    }
                }
            }).start();
        }
        long end=System.currentTimeMillis();
        System.out.println("共耗时"+(end-start));
    }
}
