package com.multithread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class CachedRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread: "+Thread.currentThread().getName());
    }
}
public class Cached_ThreadPool_q9 {
    public static void main(String[] args){
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        System.out.println("...BEFORE..");
        System.out.println("get Task count before:"+ executor.getTaskCount());
        System.out.println("Current threads in pool: "+executor.getPoolSize());
        System.out.println("Currently executing threads: " + executor.getActiveCount());
        executor.submit(new CachedRunnable());
        executor.submit(new CachedRunnable());
        executor.shutdown();
        System.out.println("\n...AFTER..");
        System.out.println("get Task count after:"+ executor.getTaskCount());
        System.out.println("Current threads in pool: "+executor.getPoolSize());
        System.out.println("Currently executing threads: " + executor.getActiveCount());
    }
}
