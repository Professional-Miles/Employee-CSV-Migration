package com.spartaglobal.io;

import java.sql.*;

public class DatabaseWriter {

    private static String mysql = "jdbc:mysql://localhost:3306/";
    private static String mysqlUser = "root";
    private static String mysqlPass = "SpartaPass!";

    public static void createDatabase(String dataPath){

        try (Connection conn = DriverManager.getConnection(mysql,mysqlUser,mysqlPass)) {
            if (conn != null){
            Statement statement = conn.createStatement();
            statement.execute("CREATE DATABASE " + dataPath);
            conn.setAutoCommit(false);
            conn.commit(); // now the database physically exists

        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(String name, String dataPath){
        try (Connection conn = DriverManager.getConnection(mysql+dataPath,mysqlUser,mysqlPass)) {
            if (conn != null) {
                Statement statement = conn.createStatement();
                if (tableExists(name, dataPath)) {
                    statement.execute("DROP TABLE " + name);
                }
                statement.executeUpdate("CREATE TABLE " + name + " " +
                        "(ID INTEGER not NULL AUTO_INCREMENT, " +
                        "Employee_ID INTEGER not NULL, " +
                        "Title VARCHAR(5), " +
                        "First_Name VARCHAR(255), " +
                        "Middle_Initial CHAR(5), " +
                        "Last_Name VARCHAR(255), " +
                        "Gender CHAR(5), " +
                        "Birth_Date DATE, " +
                        "Join_Date DATE, " +
                        "Salary INTEGER, " +
                        "primary key (ID))");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean databaseExists(String dataPath){
        ResultSet rs = null;
        boolean result = false;
        try (Connection conn = DriverManager.getConnection(mysql+dataPath,mysqlUser,mysqlPass)) {
            if (conn != null){
                rs = conn.getMetaData().getCatalogs();
                while(rs.next()){
                    String catalogs = rs.getString(1);
                    if(dataPath.equals(catalogs)){
                        result = true;
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean tableExists(String name, String dataPath) throws SQLException {
        ResultSet rs = null;
        Connection conn = DriverManager.getConnection(mysql+dataPath,mysqlUser,mysqlPass);
            if (conn != null) {
            DatabaseMetaData dbm = conn.getMetaData();
            rs = dbm.getTables(null,null,name,null);
            }
        return rs.next();
    }
}
