package com.spartaglobal.io;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseWriter {

    private static String mysql = "jdbc:mysql://localhost:3306/";
    private static String mysqlUser = "root";
    private static String mysqlPass = "SpartaPass!";




    public static void createDatabase(String dataPath){

        try (Connection conn = DriverManager.getConnection(mysql,mysqlUser,mysqlPass)) {
        if (databaseExists(dataPath+".db")){
            System.out.println("Database already exists.");
        } else {
            Statement statement = conn.createStatement();
            statement.execute("CREATE DATABASE "+ dataPath );
            conn.setAutoCommit(false);
            conn.commit(); // now the database physically exists
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(String name, String dataPath){
        try (Connection conn = DriverManager.getConnection(mysql+dataPath,mysqlUser,mysqlPass)) {
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE " + name);
            statement.execute("CREATE TABLE " + name + " " +
                    "(ID INTEGER not NULL, " );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean databaseExists(String databasePath){
        File dbFile = new File(databasePath);
        return dbFile.exists();
    }

//    public static void tableExists(String name, String dataPath) {
//        try (Connection conn = DriverManager.getConnection(mysql+dataPath)) {
//            Statement statement = conn.createStatement();
//            statement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
