package com.spartaglobal.control;


import com.spartaglobal.io.UserDaoInput;
import com.spartaglobal.model.Employees;
import com.spartaglobal.model.EmployeesDao;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

public class DaoWorker{

    EmployeesDao empDao = EmployeesDao.getInstance();

    public static void worker(String[] info, UserDaoInput udi, ArrayList<Employees> empQuery){
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
                            empQuery.add(EmployeeListMaker.employeePopulateQuery(rs.getString(2) + "," + rs.getString(3)
                                    + "," + rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6)
                                    + "," + rs.getString(7) + "," + rs.getString(8)+ "," + rs.getString(9)
                                    + "," + rs.getString(10) + "," + rs.getString(11)));
                        }
                        System.out.println("Number of records: " + i);
                        break;
                    case "Get":
                        empDao.getEmployeeById();
                        ps = conn.prepareStatement(empDao.getSql() + " " + empDao.getSqlWhere() + " " + udi.getWhere());
                        rs = ps.executeQuery();
                        rs.next();
                        empQuery.add(EmployeeListMaker.employeePopulateQuery(rs.getString(2) + "," + rs.getString(3)
                                + "," + rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6)
                                + "," + rs.getString(7) + "," + rs.getString(8)+ "," + rs.getString(9)
                                + "," + rs.getString(10) + "," + rs.getString(11)));
                        break;
                    case "Insert":
                        empDao.insertEmployee();
                        PreparedStatement pst = conn.prepareStatement(empDao.getSqlDo()+empDao.getSqlWhat(), statement.RETURN_GENERATED_KEYS);
                        String[] empList =  udi.getWhat().split(",");
                        Employees emp = new Employees(Integer.valueOf(empList[0]), empList[1], empList[2], empList[3].charAt(0), empList[4], empList[5].charAt(0),
                                empList[6], DataSetValidator.dateFormatSql(empList[7]), DataSetValidator.dateFormatSql(empList[8]), Integer.valueOf(empList[9]));
                        pst.setString(1, emp.getEmployeeID().toString());
                        pst.setString(2, emp.getNamePrefix());
                        pst.setString(3, emp.getFirstName());
                        pst.setString(4, emp.getMiddleInitial().toString());
                        pst.setString(5, emp.getLastName());
                        pst.setString(6, emp.getGender().toString());
                        pst.setString(7, emp.getEmail());
                        pst.setString(8, emp.getDateOfBirth().toString());
                        pst.setString(9, emp.getDateOfJoining().toString());
                        pst.setString(10, emp.getSalary().toString());
                        pst.executeUpdate();
                        break;
                    case "Update":
                        empDao.updateEmployeeById();
                        ps = conn.prepareStatement(empDao.getSqlDo() + empDao.getSqlWhat() + udi.getWhat() + " " + empDao.getSqlWhere() + udi.getWhere());
                        ps.executeUpdate();
                        break;
                    case "Delete":
                        empDao.deleteEmployeeById();
                        ps = conn.prepareStatement(empDao.getSqlDo() + empDao.getSqlWhere() + udi.getWhere());
                        ps.executeUpdate();
                        break;
                }
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }
}
