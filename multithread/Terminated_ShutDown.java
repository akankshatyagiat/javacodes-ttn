package com.multithread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class Task_New implements Runnable{
    private final String name; private final int number;
    public Task_New(String name,int num){
        this.name=name;
        this.number=num;
    }
    @Override
    public void run() {
        System.out.println("Task: ("+name+") running");
        for(int i=number*100;i<100*number+10;i++)
            System.out.print(i+" ");
        System.out.println("\nTask: ("+name+") COMPLETED");
    }
}
public class Terminated_ShutDown {
    public static void main(String[] name){
        ExecutorService threadExecutor=Executors.newFixedThreadPool(3);
        threadExecutor.submit(new Thread(new Task_New("Akanksha",1) ));
        threadExecutor.submit(new Thread(new Task_New("Mudit",2) ));
        threadExecutor.submit(new Thread(new Task_New("Tanya",3) ));
        threadExecutor.shutdown();
        System.out.println(" Is Executor is ShutDown? :"+ threadExecutor.isShutdown());
        System.out.println(" Is Executor is Terminated? :"+ threadExecutor.isTerminated());
    }
}
