package com.spartaglobal.io;

import com.spartaglobal.model.Employees;
import java.io.*;
import java.util.ArrayList;

public class CSVWrite {

    public static void cvsWrite(ArrayList<Employees> empQuery){
        try (BufferedWriter out = new BufferedWriter(new FileWriter("EmployeeOutput.csv"))){
            for (Employees employees : empQuery) {
                out.write(employees.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
