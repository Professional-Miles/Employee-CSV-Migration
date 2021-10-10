package com.spartaglobal.multi;

import com.spartaglobal.io.DatabaseWriter;
import com.spartaglobal.model.Employees;

import java.util.ArrayList;

public class MultiThreading extends Thread{

    private String[] info;
    private ArrayList<Employees> empList;
    private int split;

    public MultiThreading(String[] info, ArrayList<Employees> empList,int split){
        this.info = info;
        this.empList = empList;
        this.split = split;
    }

    @Override
    public void run() {
        DatabaseWriter.populateTable(info,empList, split);
    }



    public String[] getInfo() {
        return info;
    }

    public void setInfo(String[] info) {
        this.info = info;
    }

    public ArrayList<Employees> getEmpList() {
        return empList;
    }

    public void setEmpList(ArrayList<Employees> empList) {
        this.empList = empList;
    }

}
