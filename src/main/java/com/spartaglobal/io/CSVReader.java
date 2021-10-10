package com.spartaglobal.io;

import com.spartaglobal.control.EmployeeListMaker;
import com.spartaglobal.control.DataSetValidator;
import com.spartaglobal.model.Employees;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class CSVReader {

    public static void cvsRead(ArrayList<Employees> empList){
        String line;
        try (BufferedReader in = new BufferedReader(new FileReader("EmployeeRecords.csv"))){
            in.readLine();
            while ((line = in.readLine()) != null){
                empList.add(EmployeeListMaker.employeePopulate(line));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        DataSetValidator.employeeListDuplicateChecker(empList);
    }

}
