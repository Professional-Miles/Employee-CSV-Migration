package com.spartaglobal.io;

import com.spartaglobal.model.Employees;

import java.sql.*;
import java.util.ArrayList;

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

    public static void populateTable(String name, String dataPath, ArrayList<Employees> data){

        String sql = "INSERT INTO " + name + " (Employee_ID, Title, First_Name, Middle_Initial, Last_Name, Gender, Email, Birth_Date, Join_Date, Salary) "
                        + "VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(mysql+dataPath,mysqlUser,mysqlPass)) {
            if (conn != null) {
                Statement statement = conn.createStatement();
                PreparedStatement pst = conn.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);
                for (int i = 0; i < data.size(); i++){
                    pst.setString(1, data.get(i).getEmployeeID().toString());
                    pst.setString(2, data.get(i).getNamePrefix());
                    pst.setString(3, data.get(i).getFirstName());
                    pst.setString(4, data.get(i).getMiddleInitial().toString());
                    pst.setString(5, data.get(i).getLastName());
                    pst.setString(6, data.get(i).getGender().toString());
                    pst.setString(7, data.get(i).getEmail());
                    pst.setString(8, data.get(i).getDateOfBirth().toString());
                    pst.setString(9, data.get(i).getDateOfJoining().toString());
                    pst.setString(10, data.get(i).getSalary().toString());
                    pst.executeUpdate();

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
