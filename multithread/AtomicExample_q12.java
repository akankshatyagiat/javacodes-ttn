package com.multithread;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
class AtomicCounter_class {
    private AtomicInteger count = new AtomicInteger(0);

    public int incrementAndGet() {
        return count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
public class AtomicExample_q12 {
    public static void main(String [] ar) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        AtomicCounter_class atomicCounter = new AtomicCounter_class();
        for(int i = 0; i < 200; i++) {
            executor.submit(() -> atomicCounter.incrementAndGet());
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Final Count is : " + atomicCounter.getCount());
    }
}
