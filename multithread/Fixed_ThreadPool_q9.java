package com.multithread;
import java.util.concurrent.*;
class FixedRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread: "+Thread.currentThread().getName());
    }
}
public class Fixed_ThreadPool_q9 {
    public static void main(String[] args){
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        System.out.println("...BEFORE..");
        System.out.println("get Task count before:"+ executor.getTaskCount());
        System.out.println("Current threads in pool: "+executor.getPoolSize());
        System.out.println("Currently executing threads: " + executor.getActiveCount());
        executor.submit(new FixedRunnable());
        executor.submit(new FixedRunnable());
        executor.submit(new FixedRunnable());
        executor.submit(new FixedRunnable());

        System.out.println("\n...AFTER..");
        System.out.println("get Task count after:"+ executor.getTaskCount());
        System.out.println("Current threads in pool: "+executor.getPoolSize());
        System.out.println("Currently executing threads: " + executor.getActiveCount());
        executor.shutdown();
    }
}
