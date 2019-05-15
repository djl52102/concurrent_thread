package cn.ctyun.thread.thread8;

import java.util.LinkedList;

public class ProAndCon {
    private int MAX_SIZE=2;

    private LinkedList<Integer> list=new LinkedList<>();

    class Producer implements Runnable{

        @Override
        public void run() {
            synchronized (list){
                while(list.size()==MAX_SIZE){
                    try {
                        System.out.println("仓库已满，生产者"+Thread.currentThread().getName()+"不可生产");
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(1);
                System.out.println("生产者"+Thread.currentThread().getName()+"生产，当前容量为"+list.size());
                list.notifyAll();
            }
        }
    }

    class Customer implements Runnable{

        @Override
        public void run() {
            synchronized (list){
                while(list.size()==0){
                    System.out.println("仓库容量为空，消费者"+Thread.currentThread().getName()+"不可消费");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.removeFirst();
                System.out.println("消费者"+Thread.currentThread().getName()+"消费，仓库容量为"+list.size());
                list.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        ProAndCon proAndCon = new ProAndCon();
        Producer producer = proAndCon.new Producer();
        Customer customer = proAndCon.new Customer();
        for (int i=0;i<10;i++){
            new Thread(customer).start();
            new Thread(producer).start();
        }
    }
}
