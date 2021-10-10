package com.spartaglobal.model;

public class EmployeesDao implements EmployeeDao {

    private String sqlQ;
    private String sqlDo;
    private String sqlWhat;
    private String sqlWhere;

    public String getSql() {
        return sqlQ;
    }

    public String getSqlDo() {
        return sqlDo;
    }

    public String getSqlWhat() {
        return sqlWhat;
    }

    public String getSqlWhere() {
        return sqlWhere;
    }

    @Override
    public void getAllEmployees() {
        this.sqlQ = "SELECT * FROM EMPLOYEE";
    }

    @Override
    public void getEmployeeById() {
        this.sqlQ = "SELECT * FROM EMPLOYEE";
        this.sqlWhere = "WHERE EMPLOYEE_ID = ";
    }

    @Override
    public void insertEmployee() {
        this.sqlDo = "INSERT INTO EMPLOYEE (Employee_ID, Title, First_Name, Middle_Initial, Last_Name, Gender, Email, Birth_Date, Join_Date, Salary) ";
        this.sqlWhat = "";
    }

    @Override
    public void updateEmployeeById() {
        this.sqlDo = "UPDATE EMPLOYEE ";
        this.sqlWhat = "SET ";
        this.sqlWhere = "WHERE EMPLOYEE_ID = ";
    }

    @Override
    public void deleteEmployeeById() {
        this.sqlDo = "DELETE FROM EMPLOYEE ";
        this.sqlWhere = "WHERE EMPLOYEE_ID = ";
    }
}
