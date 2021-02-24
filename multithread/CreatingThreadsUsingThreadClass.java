package com.multithread;
class ThreadPrintsTyagi extends Thread
{
    public void run() {
        for(int i=0;i<5;i++) {
            System.out.println("Hi Tyagi!");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class ThreadPrintsAkanksha extends Thread {
    public void run() {
        for(int i=0;i<5;i++) {
            System.out.println("Hi Akanksha!");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class CreatingThreadsUsingThreadClass {
    public static void main(String[] arg) throws InterruptedException {
        ThreadPrintsTyagi thread2 = new ThreadPrintsTyagi();
        ThreadPrintsAkanksha thread1 = new ThreadPrintsAkanksha();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("main executed in the last....!!!");
    }
}