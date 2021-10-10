package com.spartaglobal.io;

import com.spartaglobal.model.Employees;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CSVReaderTest {

    @Test
    void cvsReadTest() {
        ArrayList<Employees> testList = new ArrayList<>();
        CSVReader.cvsRead(testList);
        assertEquals(9943,testList.size());
    }

}