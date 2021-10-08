package com.spartaglobal.io;

import com.spartaglobal.control.DatabaseValidator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {

    public static void createTable(String[] info){
        try (Connection conn = DriverManager.getConnection(info[2]+info[0],info[3],info[4])) {
            if (conn != null) {
                Statement statement = conn.createStatement();
                if (DatabaseValidator.tableExists(info)) {
                    statement.execute("DROP TABLE " + info[1]);
                }
                statement.executeUpdate("CREATE TABLE " + info[1] + " " +
                        "(ID INTEGER not NULL AUTO_INCREMENT, " +
                        "Employee_ID INTEGER not NULL, " +
                        "Title VARCHAR(5), " +
                        "First_Name VARCHAR(255), " +
                        "Middle_Initial CHAR(5), " +
                        "Last_Name VARCHAR(255), " +
                        "Gender CHAR(5), " +
                        "Email VARCHAR(50), " +
                        "Birth_Date DATE, " +
                        "Join_Date DATE, " +
                        "Salary INTEGER, " +
                        "primary key (ID))");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
