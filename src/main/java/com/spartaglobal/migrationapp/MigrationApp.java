package com.spartaglobal.migrationapp;

import com.spartaglobal.control.DaoWorker;
import com.spartaglobal.io.*;
import com.spartaglobal.model.DatabaseInfo;
import com.spartaglobal.model.Employees;
import com.spartaglobal.multithreading.Threading;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;

public class MigrationApp {

    private static Logger log = Logger.getLogger("Migration App logger.");

    public static void main(String[] args) throws InterruptedException {

        PropertyConfigurator.configure("log4j.properties");
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
