package com.spartaglobal.control;

import com.spartaglobal.model.Employees;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.*;

class DataSetValidatorTest {

    @Test
    void dateFormatSqlTest() {
        String line;
        try (BufferedReader in = new BufferedReader(new FileReader("EmployeeRecords.csv"))) {
            in.readLine();
            line = in.readLine();
            Employees em = EmployeeListMaker.employeePopulate(line);
            Date dob2 = Date.valueOf("1982-9-21");
            assertEquals(dob2, em.getDateOfBirth());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void isDataValidTest() {
        String data = "34,Mr.,Swirly,M,Sir,F,sirlysir@email.com,04/04/2000,05/05/1998,33333";
        assertEquals(false,DataSetValidator.isDataValid(data));
    }
}