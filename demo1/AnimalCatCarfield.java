package cn.ctyun.thread.demo1;

import java.util.ArrayList;
import java.util.List;

public class AnimalCatCarfield {
    public static void main(String[] args) {
        /*ArrayList<Animal> animals = new ArrayList<Animal>();
        ArrayList<Cat> cats = new ArrayList<Cat>();
        ArrayList<Garfield> garfields = new ArrayList<>();

        animals.add(new Animal());
        cats.add(new Cat());
        garfields.add(new Garfield());

        List<? super Cat> objects=animals;*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程执行run");
            }
        }
        ){
        }.start();

    }
}
