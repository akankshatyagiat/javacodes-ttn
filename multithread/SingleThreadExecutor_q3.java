package com.multithread;
import java.util.concurrent.*;

class TaskThread extends Thread{
    private final int number;
    public TaskThread(int number){
        this.number=number;
    }
    @Override
    public void run() {
        System.out.println("Task: "+number+" running");
        for(int i=number*100;i<100*number+10;i++)
            System.out.print(i+" ");
        System.out.println("\nTask: "+number+" COMPLETED");
    }
}
public class SingleThreadExecutor_q3 {
    public static void main(String[] args){
        ExecutorService serviceVariable;
        serviceVariable=Executors.newSingleThreadExecutor();
        //execution of (i+1)th thread will start after
        // (i)th thread completes its execution.
        for(int i=1;i<=5;i++)
            serviceVariable.execute(new TaskThread(i));
        serviceVariable.shutdown();
    }
}
