package com.multithread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScheduleFixed_Delay implements Runnable {
    String name;
    public ScheduleFixed_Delay(String name) {
        this.name=name;
    }
    @Override
    public void run() {
        System.out.println("("+this.name+") executed on: "+
                LocalDateTime.now()
                        .format(DateTimeFormatter
                         .ofPattern("dd-MMM-yyyy::ss")));
    }
}
