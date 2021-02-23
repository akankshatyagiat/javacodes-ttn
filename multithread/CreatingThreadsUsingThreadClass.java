package com.multithread;

class ThreadExtend extends Thread {
    public void run()
    {
        for(int i=0;i<5;i++)
            System.out.println(i+" hello AkankshaTyagi," +
                    ", call from Thread id, : "+
                    Thread.currentThread().getId());
    }
}
public class CreatingThreadsUsingThreadClass {
    public static void main(String[] arg)
    {
        System.out.println("Three threads created:: \n");
        ThreadExtend thread1=new ThreadExtend();
        thread1.start();
        ThreadExtend thread2=new ThreadExtend();
        thread2.start();
        ThreadExtend thread3=new ThreadExtend();
        thread3.start();
    }

}
