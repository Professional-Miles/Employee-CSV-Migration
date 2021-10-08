package com.spartaglobal.migrationapp;

import com.spartaglobal.io.*;
import com.spartaglobal.model.DatabaseInfo;
import com.spartaglobal.model.Employees;

import java.util.ArrayList;

public class MigrationApp {

    public static void main(String[] args) {

        DatabaseInfo di = new DatabaseInfo();
        ArrayList<Employees> employeesList = new ArrayList<>();

        CSVReader.cvsRead(employeesList);

        DatabaseCreator.createDatabase(di.getInfo());
        TableCreator.createTable(di.getInfo());

        long startTime = System.currentTimeMillis();
        DatabaseWriter.populateTable(di.getInfo(),employeesList);
        long stopTime = System.currentTimeMillis();

        System.out.println(stopTime - startTime);

    }


}
