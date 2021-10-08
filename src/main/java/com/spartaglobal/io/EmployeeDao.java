package com.spartaglobal.io;

import com.spartaglobal.model.Employees;

import java.util.Set;

public interface EmployeeDao {

    Employees getEmployee();
    Set<Employees> getAllEmployees();
    Employees getEmployeeByFirstAndLastName();
    boolean insertEmployee();
    boolean updateEmployee();
    boolean deleteEmployee();

}
