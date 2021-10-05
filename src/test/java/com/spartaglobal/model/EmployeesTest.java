package com.spartaglobal.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesTest {

    @Test
    public void dateFormatSqlTestPass() throws ParseException {
        Employees em = new Employees();
        String dob1 = "3/4/2000";
        Date dob2 = Date.valueOf("2000-3-4");
        assertEquals(dob2, em.dateFormatSql(dob1));
    }

}