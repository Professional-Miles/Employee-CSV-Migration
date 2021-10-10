package com.spartaglobal.model;

import com.spartaglobal.model.Employees;

import java.util.ArrayList;

public interface EmployeeDao {

    void getAllEmployees();
    void getEmployeeById();
    void insertEmployee();
    void updateEmployeeById();
    void deleteEmployeeById();

}
