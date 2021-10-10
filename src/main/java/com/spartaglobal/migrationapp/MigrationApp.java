package com.spartaglobal.migrationapp;

import com.spartaglobal.control.DaoWorker;
import com.spartaglobal.io.*;
import com.spartaglobal.model.DatabaseInfo;
import com.spartaglobal.model.Employees;
import com.spartaglobal.multi.MultiThreading;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MigrationApp {

    public static void main(String[] args) throws InterruptedException {

        DatabaseInfo di = new DatabaseInfo();
        ArrayList<Employees> employeesList = new ArrayList<>();
        CSVReader.cvsRead(employeesList);

        DatabaseCreator.createDatabase(di.getInfo());
        TableCreator.createTable(di.getInfo());

        long startTime = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool((employeesList.size()/1000)+1);
        for (int i = 0; i < (employeesList.size()/1000)+1; i++){
            service.execute(new MultiThreading(di.getInfo(),employeesList,i));
        }
        service.shutdown();
        try {
            service.awaitTermination(70, TimeUnit.SECONDS);
        } catch (InterruptedException e){

        }
        long stopTime = System.currentTimeMillis();
        System.out.println("\nTime taken: " + ((stopTime - startTime)/1000) + " seconds.\n");

        UserDaoInput userInput = UserDaoInput.getInstance();
        userInput.getTaskQ();
        DaoWorker.worker(di.getInfo(), userInput);


    }


}
