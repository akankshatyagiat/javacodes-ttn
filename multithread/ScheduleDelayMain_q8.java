package com.multithread;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleDelayMain_q8 {

    public static void main(String[] args){
        System.out.println("2 threads in a pool and ScheduledAtFixedDelay:: ");
        ScheduledExecutorService schedule= Executors.newScheduledThreadPool(2);
        Runnable task1=new ScheduleFixed_Delay("task 1");
        Runnable task2=new ScheduleFixed_Delay("task 2");
        Runnable task3=new ScheduleFixed_Delay("task 3");
        Runnable task4=new ScheduleFixed_Delay("task 4");

        schedule.scheduleAtFixedRate(task1,2,4, TimeUnit.SECONDS);
        schedule.scheduleAtFixedRate(task2,2,1, TimeUnit.SECONDS);
        schedule.scheduleAtFixedRate(task3,2,5, TimeUnit.SECONDS);
        schedule.scheduleAtFixedRate(task4,2,10, TimeUnit.SECONDS);
    }
}

