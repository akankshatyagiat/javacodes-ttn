package com.multithread;
import java.util.*;
import java.util.concurrent.*;

public class WaitForTheExecution_q7 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service_wait = Executors.newFixedThreadPool(2);
        List<Future<Integer>> resultListFuture=new ArrayList<>();
        System.out.println("main thread will wait for the completion of all the tasks.." +
                "as awaitsTermination is applied");
        //adding results upto 5 factorials in the list
        for(int i=1;i<=5;i++){
            CalculateFactorial thread=new CalculateFactorial(i);
            Future<Integer> particularResult=service_wait.submit(thread);
            resultListFuture.add(particularResult);
        }//for

        service_wait.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("....MAIN...");
        for (int i=0;i<resultListFuture.size();i++) {
            Future<Integer> aFuture=resultListFuture.get(i);
            Integer factorialNum=null;
            factorialNum=aFuture.get();
            System.out.printf("Main: factorial %d: %d\n", (i+1), factorialNum);
        }//for
        service_wait.shutdown();
    } }
