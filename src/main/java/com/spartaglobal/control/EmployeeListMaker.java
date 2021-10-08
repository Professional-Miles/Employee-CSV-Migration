package com.spartaglobal.control;

import com.spartaglobal.model.Employees;
import java.text.ParseException;


public class EmployeeListMaker {

    public static Employees employeePopulate (String data) throws ParseException {

        String[] empList = data.split(",");
        if (!DataSetValidator.isDataValid(data)) {
            System.err.println("Data isn't valid!");
            System.exit(1);
        }
        Employees emp = new Employees(Integer.valueOf(empList[0]), empList[1], empList[2], empList[3].charAt(0), empList[4], empList[5].charAt(0),
                empList[6], DataSetValidator.dateFormatSql(empList[7]), DataSetValidator.dateFormatSql(empList[8]), Integer.valueOf(empList[9]));
        return emp;
    }





}
