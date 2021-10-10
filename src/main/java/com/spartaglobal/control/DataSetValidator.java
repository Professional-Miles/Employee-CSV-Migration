package com.spartaglobal.control;

import com.spartaglobal.model.Employees;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

public class DataSetValidator {

    public static boolean isDataValid(String data) {
        boolean validity = true;
        String[] empList = data.split(",");
        if (Integer.parseInt(empList[0]) < 0)
            validity = false;
        if (empList[1].length() > 5 || !empList[1].matches("[a-zA-Z]+\\."))
            validity = false;
        if (empList[2].length() > 256 || !empList[2].matches("\\p{L}+"))
            validity = false;
        if (!empList[3].substring(0,1).matches("[a-zA-Z]+"))
            validity = false;
        if (empList[4].length() > 256 || !empList[4].matches("\\p{L}+"))
            validity = false;
        if (!empList[5].matches("[FMfm]"))
            validity = false;
        if (!empList[6].matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])"))
            validity = false;
        if (!empList[7].matches("(0?[1-9]|1[0-2])[/?$](0?[1-9]|[12]\\d|30|31)[/?$](\\d{4}|\\d{2})"))
            validity = false;
        if (!empList[8].matches("(0?[1-9]|1[0-2])[/?$](0?[1-9]|[12]\\d|30|31)[/?$](\\d{4}|\\d{2})"))
            validity = false;
        if (Integer.parseInt(empList[9]) < 0)
            validity = false;
        return !validity;
    }

    public static void employeeListDuplicateChecker (ArrayList<Employees> data) {
        HashSet<Employees> uniqueElements = new HashSet<>(data);
        int nSize = uniqueElements.size();
        int oSize = data.size();
        data.clear();
        data.addAll(uniqueElements);
        int dupeAmount = oSize - nSize;
        System.out.println("Original number of Employee entries: " + oSize + '\n' + "Valid number of Employee entries: " + nSize + '\n' + "Number of duplicate entries: " + dupeAmount);
    }

    public static Date dateFormatSql(String date) throws ParseException {
        java.util.Date dateOriginal = new SimpleDateFormat("MM/dd/yyyy").parse(date);
        return new Date(dateOriginal.getTime());
    }


}
