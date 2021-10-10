package com.spartaglobal.migrationapp;

import com.spartaglobal.io.*;
import com.spartaglobal.model.DatabaseInfo;
import com.spartaglobal.model.Employees;
import com.spartaglobal.multi.MultiThreading;

import java.util.ArrayList;

public class MigrationApp {

    public static void main(String[] args) throws InterruptedException {

        DatabaseInfo di = new DatabaseInfo();
        ArrayList<Employees> employeesList = new ArrayList<>();

        CSVReader.cvsRead(employeesList);

        DatabaseCreator.createDatabase(di.getInfo());
        TableCreator.createTable(di.getInfo());

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < (employeesList.size()/1000)+1; i++){

            MultiThreading threader = new MultiThreading(di.getInfo(),employeesList,i);
            threader.start();
        }

        long stopTime = System.currentTimeMillis();

        System.out.println(stopTime - startTime);

    }


}
