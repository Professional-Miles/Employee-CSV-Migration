package com.spartaglobal.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseWriter {

    public static void createDatabase(){

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db")) {




        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
