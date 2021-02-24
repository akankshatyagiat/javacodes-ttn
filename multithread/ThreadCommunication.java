package com.multithread;
class RandomClass extends Thread {
    int total;
    @Override public void run() {
        synchronized (this) {
            for (int i = 0; i <= 100; i++) {
                total += i;
            }
            notify();
        }
    }
}
public class ThreadCommunication {
    public static void main(String[] args) {
        RandomClass b = new RandomClass();
        b.start();
        synchronized (b) {
            try {
                System.out.println("Waiting for 2 to complete...");
                b.wait();
                System.out.println("done..");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Total is: " + b.total); }
    } //main
}
