package com.multithread;
class Counter {
    int count;
    public synchronized void increment(){
        count++; }
}
public class Synchronised_q10 {
    public static  void main(String[] args) throws InterruptedException {
        Counter obj=new Counter();
        Thread thread1=new Thread(new Runnable(){
            public void run() {
                for(int i=1;i<=1000;i++){
                    obj.increment();
                } //for
            } //run
        }); // thread1

        Thread thread2=new Thread(new Runnable(){
            public void run() {
                for(int i=1;i<=2000;i++){
                    obj.increment();
                } //for
            } //run
        }); // thread2
        thread1.start();thread2.start();
        thread1.join(); thread2.join();
        System.out.println("count:  "+obj.count);
    }
}
