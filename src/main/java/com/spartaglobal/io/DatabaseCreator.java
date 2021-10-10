package com.spartaglobal.io;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {

    private static final Logger log = Logger.getLogger("Database creator logger.");

    public static void createDatabase(String[] info){
            try (Connection conn = DriverManager.getConnection(info[2],info[3],info[4])) {
                if (conn != null){
                    Statement statement = conn.createStatement();
                    statement.execute("CREATE DATABASE IF NOT EXISTS " + info[0]);
                    conn.setAutoCommit(false);
                    conn.commit();
                }
            } catch (SQLException e) {
                log.error("SQL Exception thrown.");
                e.printStackTrace();
            }
        }
    }
