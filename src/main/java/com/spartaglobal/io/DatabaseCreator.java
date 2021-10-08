package com.spartaglobal.io;

import com.spartaglobal.control.DatabaseValidator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {

    public static void createDatabase(String[] info){
       // if (!DatabaseValidator.databaseExists(info)){
            try (Connection conn = DriverManager.getConnection(info[2],info[3],info[4])) {
                if (conn != null){
                    Statement statement = conn.createStatement();
                    statement.execute("CREATE DATABASE IF NOT EXISTS " + info[0]);
                    conn.setAutoCommit(false);
                    conn.commit(); // now the database physically exists
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

//}
