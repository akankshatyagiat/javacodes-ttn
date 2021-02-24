package com.multithread;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;

class ScheduledTask implements Callable<String> {
    private final String name;

    public ScheduledTask(String name){
        this.name=name;
    }
    @Override
    public String call() throws Exception {
        return "("+this.name+") executed on: "+
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy::ss"));
    }
}
public class ScheduledMain_q8 {
    public static void main(String[] args){
        ScheduledExecutorService scService;
        scService= Executors.newScheduledThreadPool(2);
        List<ScheduledFuture<String>> listResult=new ArrayList<>();

        for(int i=1;i<=5;i++){
            ScheduledTask task=new ScheduledTask("Task:: "+i);
            ScheduledFuture<String> particular=scService.schedule(task,i*5, TimeUnit.SECONDS);
            listResult.add(particular);
        }//for

        scService.shutdown();
        try {
            scService.awaitTermination(1,TimeUnit.SECONDS);

            for (ScheduledFuture<String> aFuture:listResult)
                System.out.println(aFuture.get());

        } catch (InterruptedException e) { e.printStackTrace(); }
        catch (ExecutionException e) { e.printStackTrace(); }
    }
}
