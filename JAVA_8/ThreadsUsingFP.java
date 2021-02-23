package com.JAVA_8;

import java.io.IOException;

public class ThreadsUsingFP {
        public static void main(String[] ar) {
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<5;i++)
                        System.out.println(
                                Thread.currentThread().getId()
                                +" : "+i
                        );
                }
            };
            //using FP
            Runnable runnable2=() -> {
                for(int i=0;i<5;i++)
                System.out.println(
                        Thread.currentThread().getId()
                                +" : "+i);
            };
            Thread thread1=new Thread(runnable);
            thread1.start();
            Thread thread2=new Thread(runnable);
            thread2.start();
            Thread thread3=new Thread(runnable);
            thread3.start();

        }
}
