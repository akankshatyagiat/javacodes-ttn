package com.multithread;
class ImplementRunnable implements Runnable {
    public void run()
    {
        for(int i=0;i<5;i++)
            System.out.println(i+" hello AkankshaTyagi," +
                    ", call from Runnable, thread id, : "+
                    Thread.currentThread().getId());
    }
}
public class CreatingThreadsUsingRunnable {
    public static void main(String[] arg)
    {
        System.out.println("Three threads created:: \n");
        Thread thread1=new Thread(new ImplementRunnable());
        thread1.start();
        Thread thread2=new Thread(new ImplementRunnable());
        thread2.start();
        Thread thread3=new Thread(new ImplementRunnable());
        thread3.start();
    }

}

