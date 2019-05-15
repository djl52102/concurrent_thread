package cn.ctyun.thread.concurrent_container;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class T3_Blocking_Array {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        for(int i=0;i<10;i++){
            queue.add("a"+i);
        }
        //queue.add("bb");

        /*try {
            cc = queue.offer("cc",2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cc);*/

        queue.put("cc");
    }
}
