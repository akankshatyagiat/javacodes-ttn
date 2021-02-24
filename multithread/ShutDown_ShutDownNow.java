package com.multithread;

import java.util.List;
import java.util.concurrent.*;

public class ShutDown_ShutDownNow {
    public static void main(String[] args) {
        //execution of 2nd thread will start after 1st thread completes its execution.
        ExecutorService serviceVariable;
        serviceVariable = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 5; i++)
            serviceVariable.execute(new TaskThread(i));
        List<Runnable> returnedTasks = serviceVariable.shutdownNow();
        System.out.println("\nThe tasks in the ready state: \n" +
                returnedTasks);
    }
}

//    public static void main(String[] args) {
//        //execution of i+1 th thread will start after ith thread completes its execution.
//        ExecutorService serviceVariable ;
//        serviceVariable=Executors.newSingleThreadExecutor();
//        for (int i = 1; i <= 5; i++)
//            serviceVariable.execute(new TaskThread(i));
//        serviceVariable.shutdown();
//        System.out.println("Done everything... lets see when it will " +
//                "execute..");
//    }
//}

