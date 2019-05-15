package cn.ctyun.thread.thread8;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Container3 {
    private final int MAX_SIZE=2;

    private BlockingQueue<Integer> queue=new LinkedBlockingDeque(MAX_SIZE);

    class Producer implements Runnable{

        @Override
        public void run() {
            if(queue.size()==MAX_SIZE){
                System.out.println("仓库已满"+Thread.currentThread().getName()+"不能生产");
            }
            try {
                queue.put(1);
                System.out.println("线程"+Thread.currentThread().getName()+"正在生产，仓库容量为"+queue.size());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    class Customer implements Runnable{

        @Override
        public void run() {
            if(queue.size()==0){
                System.out.println("仓库为空"+Thread.currentThread().getName()+"不可消费");
            }
            try {
                queue.take();
                System.out.println("消费者线程"+Thread.currentThread().getName()+"正在消费,仓库容量为"+queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Container3 container3 = new Container3();
        Producer producer = container3.new Producer();
        Customer customer = container3.new Customer();
        for(int i=0;i<10;i++){
            new Thread(customer).start();
            new Thread(producer).start();
        }
    }

}
