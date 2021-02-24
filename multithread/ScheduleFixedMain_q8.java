package com.multithread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleFixedMain_q8 {
    public static void main(String[] args){
        ScheduledExecutorService schedule= Executors.newSingleThreadScheduledExecutor();
        Runnable task1=new ScheduleFixed_Delay("AkankshaTyagi");
        Runnable task2=new ScheduleFixed_Delay("ToTheNew");
        Runnable task3=new ScheduleFixed_Delay("HelloHiBYEBYE");
        Runnable task4=new ScheduleFixed_Delay("TTN-Noida");

        schedule.scheduleAtFixedRate(task1,2,4, TimeUnit.SECONDS);
        schedule.scheduleAtFixedRate(task2,2,1, TimeUnit.SECONDS);
        schedule.scheduleAtFixedRate(task3,2,5, TimeUnit.SECONDS);
        schedule.scheduleAtFixedRate(task4,2,10, TimeUnit.SECONDS);
    }
}
