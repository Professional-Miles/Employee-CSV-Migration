package com.spartaglobal.migrationapp;

import com.spartaglobal.io.CSVReader;
import com.spartaglobal.io.DatabaseWriter;

public class MigrationApp {

    public static void main(String[] args) {

        CSVReader.cvsRead();
        DatabaseWriter.createDatabase();

    }


}
