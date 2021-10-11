package com.spartaglobal.io;

import com.spartaglobal.model.Employees;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.ArrayList;

public class CSVWrite {

    private static final Logger log = Logger.getLogger("File output logger.");

    public static void cvsWrite(ArrayList<Employees> empQuery){
        try (BufferedWriter out = new BufferedWriter(new FileWriter("EmployeeOutput.csv"))){
            for (Employees employees : empQuery) {
                out.write(employees.toString());
            }
        } catch (IOException e) {
            log.error("IO Exception thrown. \n");
            e.printStackTrace();
        }
    }
}
