package com.spartaglobal.control;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataHandler {

    public static Date dateFormatSql(String date) throws ParseException {

        java.util.Date dateOriginal = new SimpleDateFormat("MM/dd/yyyy").parse(date);
        java.sql.Date sqlDate = new java.sql.Date(dateOriginal.getTime());
        return sqlDate;

    }




}
