package com.spartaglobal.multithreading;

import com.spartaglobal.model.Employees;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Threading {

    public static void doThreading(String[] info, ArrayList<Employees> empList){

        long startTime = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool((empList.size()/1000)+1);
        for (int i = 0; i < (empList.size()/1000)+1; i++){
            service.execute(new Task(info,empList,i));
        }
        service.shutdown();
        try {
           if (!service.awaitTermination(70, TimeUnit.SECONDS)){
               System.out.println("Threads timed out.");
           }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("\nTime taken: " + ((stopTime - startTime)/1000) + " seconds.\n");
    }

}
