package com.spartaglobal.io;

import com.spartaglobal.model.Employees;

import java.io.*;

import java.util.ArrayList;

public class CSVWrite {

    public static void cvsWrite(ArrayList<Employees> empQuery){

        String line = null;
        try (BufferedWriter out = new BufferedWriter(new FileWriter("EmployeeOutput.csv"))){
            for (int i = 0; i < empQuery.size(); i++){
                out.write(empQuery.get(i).toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }



}
