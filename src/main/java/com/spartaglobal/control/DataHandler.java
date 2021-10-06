package com.spartaglobal.control;

import com.spartaglobal.model.Employees;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DataHandler {

    public static Date dateFormatSql(String date) throws ParseException {

        java.util.Date dateOriginal = new SimpleDateFormat("MM/dd/yyyy").parse(date);
        java.sql.Date sqlDate = new java.sql.Date(dateOriginal.getTime());
        return sqlDate;

    }

    public static Employees employeePopulate (String data) throws ParseException {

        String[] empList = data.split(",");
        Employees emp = new Employees(Integer.valueOf(empList[0]),empList[1],empList[2],empList[3].charAt(0),empList[4],empList[5].charAt(0),
                empList[6], dateFormatSql(empList[7]), dateFormatSql(empList[8]),Integer.valueOf(empList[9]));

        return emp;
    }



}
