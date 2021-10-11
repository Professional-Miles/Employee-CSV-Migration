package com.spartaglobal.io;

import com.spartaglobal.control.EmployeeListMaker;
import com.spartaglobal.control.DataSetValidator;
import com.spartaglobal.model.Employees;
import org.apache.log4j.Logger;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class CSVReader {

    private static final Logger log = Logger.getLogger("CSV reader logger.");

    public static void cvsRead(ArrayList<Employees> empList){
        String line;
        try (BufferedReader in = new BufferedReader(new FileReader("EmployeeRecordsLarge.csv"))){
            in.readLine();
            while ((line = in.readLine()) != null){
                empList.add(EmployeeListMaker.employeePopulate(line));
            }
        } catch (IOException | ParseException e) {
            log.error("IO or Parse Exception thrown. \n");
            e.printStackTrace();
        }
        DataSetValidator.employeeListDuplicateChecker(empList);
    }

}
