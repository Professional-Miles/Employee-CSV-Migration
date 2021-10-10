package com.spartaglobal.migrationapp;

import com.spartaglobal.control.DaoWorker;
import com.spartaglobal.io.*;
import com.spartaglobal.model.DatabaseInfo;
import com.spartaglobal.model.Employees;
import com.spartaglobal.multithreading.Threading;

import java.util.ArrayList;

public class MigrationApp {

    public static void main(String[] args) throws InterruptedException {

        DatabaseInfo di = new DatabaseInfo();
        ArrayList<Employees> employeesList = new ArrayList<>();
        CSVReader.cvsRead(employeesList);

        DatabaseCreator.createDatabase(di.getInfo());
        TableCreator.createTable(di.getInfo());

        Threading.doThreading(di.getInfo(), employeesList);

        ArrayList<Employees> empQuery = new ArrayList<>();
        UserDaoInput userInput = UserDaoInput.getInstance();
        userInput.getTaskQ();
        DaoWorker.worker(di.getInfo(), userInput, empQuery);
        CSVWrite.cvsWrite(empQuery);


    }


}
