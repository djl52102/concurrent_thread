package cn.ctyun.thread.concurrent_container;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class T4_Transfer_Queue {
    public static void main(String[] args) throws InterruptedException {
        TransferQueue<String> aa = new LinkedTransferQueue<>();

        new Thread(()->{
            try {
                System.out.println(aa.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        aa.transfer("aaa");

        /*new Thread(()->{
            try {
                System.out.println(transfer.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();*/
    }
}
