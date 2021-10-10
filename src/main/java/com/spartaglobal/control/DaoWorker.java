package com.spartaglobal.control;


import com.spartaglobal.io.UserDaoInput;
import com.spartaglobal.model.EmployeesDao;

import java.sql.*;

public class DaoWorker{

    EmployeesDao empDao = EmployeesDao.getInstance();

    public static void worker(String[] info, UserDaoInput udi){
        EmployeesDao empDao = EmployeesDao.getInstance();
        try (Connection conn = DriverManager.getConnection(info[2]+info[0],info[3],info[4])) {
            if (conn != null) {
                Statement statement = conn.createStatement();
                PreparedStatement ps = null;
                ResultSet rs = null;
                switch(udi.getTask()){
                    case "GetAll":
                        empDao.getAllEmployees();
                        ps = conn.prepareStatement(empDao.getSql());
                        rs = ps.executeQuery();
                        int i = 0;
                        while (rs.next()){
                            i++;
                            System.out.println("ID = " + rs.getString(1) + " Employee ID = " + rs.getString(2) + ", Name = " + rs.getString(3)+rs.getString(4)
                            + " " + rs.getString(5) + " " + rs.getString(6) + ", Gender = " + rs.getString(7) + ", Email = " + rs.getString(8)
                            + ", Date of Birth = " + rs.getString(9) + ", Date of Joining = " + rs.getString(10) + ", Salary = " + rs.getString(11) + ".");
                        }
                        System.out.println("Number of records: " + i);
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}