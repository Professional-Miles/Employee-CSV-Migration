package com.spartaglobal.control;

import com.spartaglobal.model.Employees;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class DataSetValidatorTest {

    @Test
    void dateFormatSqlTest() {
        String line = null;

        try (BufferedReader in = new BufferedReader(new FileReader("EmployeeRecords.csv"))) {
            String headerLine = in.readLine();
            line = in.readLine();
            Employees em = EmployeeListMaker.employeePopulate(line);
            Date dob2 = Date.valueOf("1982-9-21");
            assertEquals(dob2, em.getDateOfBirth());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


    }
}