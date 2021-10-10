package com.spartaglobal.control;

import com.spartaglobal.model.Employees;
import org.apache.log4j.Logger;
import java.sql.Date;
import java.text.ParseException;

public class EmployeeListMaker {

    private static final Logger log = Logger.getLogger("Employee List Maker class logger.");

    public static Employees employeePopulate (String data) throws ParseException {
        String[] empList = data.split(",");
        if (DataSetValidator.isDataValid(data)) {
            System.err.println("Data isn't valid!");
            log.error("The data to be added to the Employee object was not valid or Parse Exception thrown. \n");
            System.exit(1);
        }
        return new Employees(Integer.valueOf(empList[0]), empList[1], empList[2], empList[3].charAt(0), empList[4], empList[5].charAt(0),
                empList[6], DataSetValidator.dateFormatSql(empList[7]), DataSetValidator.dateFormatSql(empList[8]), Integer.valueOf(empList[9]));
    }

    public static Employees employeePopulateQuery (String data) throws ParseException {
        String[] empList = data.split(",");
        return new Employees(Integer.valueOf(empList[0]), empList[1], empList[2], empList[3].charAt(0), empList[4], empList[5].charAt(0),
                empList[6], Date.valueOf(empList[7]), Date.valueOf(empList[8]), Integer.valueOf(empList[9]));
    }
}
