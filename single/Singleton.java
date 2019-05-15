package cn.ctyun.thread.single;

public class Singleton {

    private Singleton singleton=new Singleton();

    private Singleton(){

    }

    public Singleton getSingleton(){
        return singleton;
    }
}
