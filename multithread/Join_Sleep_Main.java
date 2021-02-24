package com.multithread;

public class Join_Sleep_Main {
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
