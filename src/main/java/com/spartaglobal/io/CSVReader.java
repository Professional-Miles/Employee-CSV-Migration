package com.spartaglobal.io;


import com.spartaglobal.control.DataHandler;
import com.spartaglobal.model.Employees;

import java.io.*;

import java.text.ParseException;
import java.util.ArrayList;

public class CSVReader {

    public static void cvsRead(ArrayList<Employees> empList){

        String line = null;

        try (BufferedReader in = new BufferedReader(new FileReader("EmployeeRecords.csv"));
             BufferedWriter out = new BufferedWriter(new FileWriter("EmployeeOutput.txt"))) {
            String headerLine = in.readLine();
            while ((line = in.readLine()) != null){
                empList.add(DataHandler.employeePopulate(line));
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        DataHandler.employeeListDuplicateChecker(empList);

    }

}
