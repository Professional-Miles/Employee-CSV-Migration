package com.spartaglobal.model;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesTest {

    @Test
    public void dateFormatSqlTest() throws ParseException {
        Employees em = new Employees();
        String dob1 = "3/4/2000";
        Date dob2 = Date.valueOf("2000-3-4");
        assertEquals(dob2, em.dateFormatSql(dob1));
    }

    @Test
    public void setDateOfBirthTest() throws ParseException {
        Employees em = new Employees();
        String dob2 = ("3/4/2000");
        em.setDateOfBirth(dob2);
        assertEquals(Date.valueOf("2000-3-4"),em.getDateOfBirth());
    }

    @Test
    void setDateOfJoiningTest() throws ParseException {
        Employees em = new Employees();
        String dob2 = ("7/29/2000");
        em.setDateOfJoining(dob2);
        assertEquals(Date.valueOf("2000-7-29"),em.getDateOfJoining());
    }
}