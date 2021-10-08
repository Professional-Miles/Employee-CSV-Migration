package com.spartaglobal.io;

import com.spartaglobal.model.Employees;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseWriter {

    public static void populateTable(String[] info, ArrayList<Employees> data){

        String sql = "INSERT INTO " + info[1] + " (Employee_ID, Title, First_Name, Middle_Initial, Last_Name, Gender, Email, Birth_Date, Join_Date, Salary) "
                        + "VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(info[2]+info[0],info[3],info[4])) {
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