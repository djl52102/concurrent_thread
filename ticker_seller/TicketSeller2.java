package cn.ctyun.thread.ticker_seller;

import java.util.concurrent.ConcurrentLinkedDeque;

public class TicketSeller2 {
    static ConcurrentLinkedDeque<String> tickets=new ConcurrentLinkedDeque();

    static {
        for(int i=0;i<1000;i++){
            tickets.add("票号"+i);
        }
    }

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        for(int i=0;i<10;i++){
            new Thread(()->{
                while(true){
                    String s=tickets.poll();
                    if(s==null){break;}
                    else{
                        System.out.println("销售"+s);
                    }
                }
            }).start();
        }
        long end=System.currentTimeMillis();
        System.out.println("共耗时"+(end-start));
    }
}
