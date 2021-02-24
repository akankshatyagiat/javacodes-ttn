package com.multithread;
import java.util.*;
import java.util.concurrent.*;

public class Callable_Future_q6 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exService;
        exService= Executors.newFixedThreadPool(2);
        List<Future<Integer>> resultListFuture=new ArrayList<>();
        System.out.println("all threads will run simultaneously.." +
                "as no awaitsTermination is applied");
        //adding results upto 5 factorials in the list
        for(int i=1;i<=5;i++){
            CalculateFactorial thread=new CalculateFactorial(i);
            Future<Integer> particularResult=exService.submit(thread);
            resultListFuture.add(particularResult);
        }//for

        //exService.awaitTermination(5, TimeUnit.SECONDS);
        for (int i=0;i<resultListFuture.size();i++) {
            Future<Integer> aFuture=resultListFuture.get(i);
            Integer factorialNum=null;
            factorialNum=aFuture.get();
            System.out.printf("Main: factorial %d: %d\n", (i+1), factorialNum);
            System.out.println("Main: Is cancelled? for "+(i+1)+" :: "+aFuture.isCancelled());
            System.out.println("Main:  Is Done? :: "+(i+1)+" :: "+aFuture.isDone());
        }//for
        exService.shutdown();
    }
}
