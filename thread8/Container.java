package cn.ctyun.thread.thread8;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Container {
    private int MAX_SIZE=2;

    private LinkedList<Integer> list=new LinkedList<>();

    private Lock lock=new ReentrantLock();

    Condition producer=lock.newCondition();

    Condition consumer=lock.newCondition();

    class Producer implements Runnable{

        @Override
        public void run() {
                lock.lock();

            try {
                while(list.size()==MAX_SIZE){
                        System.out.println("仓库已满，生产者"+Thread.currentThread().getName()+"不可生产");
                        producer.await();
                }
                list.add(1);
                System.out.println("生产者"+Thread.currentThread().getName()+"生产，当前容量为"+list.size());
                consumer.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    class Customer implements Runnable{

        @Override
        public void run() {
                lock.lock();
            try {
                while(list.size()==0){
                    System.out.println("仓库容量为空，消费者"+Thread.currentThread().getName()+"不可消费");
                    consumer.await();
                }
                list.removeFirst();
                System.out.println("消费者"+Thread.currentThread().getName()+"消费，仓库容量为"+list.size());
                producer.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ProAndCon proAndCon = new ProAndCon();
        ProAndCon.Producer producer = proAndCon.new Producer();
        ProAndCon.Customer customer = proAndCon.new Customer();
        for (int i=0;i<10;i++){
            new Thread(customer).start();
            new Thread(producer).start();
        }
    }
}
