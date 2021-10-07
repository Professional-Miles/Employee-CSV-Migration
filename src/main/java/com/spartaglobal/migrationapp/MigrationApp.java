package com.spartaglobal.migrationapp;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.spartaglobal.io.CSVReader;
import com.spartaglobal.io.DatabaseWriter;
import com.spartaglobal.model.Employees;

import java.util.ArrayList;

public class MigrationApp {

    public static void main(String[] args) {

        final String dbpath = "employees";
        final String employeeTable = "EMPLOYEE";
        ArrayList<Employees> employeesList = new ArrayList<>();


        CSVReader.cvsRead(employeesList);
        if(!DatabaseWriter.databaseExists(dbpath)) {
            DatabaseWriter.createDatabase(dbpath);
        }
        DatabaseWriter.createTable(employeeTable,dbpath);


    }


}
