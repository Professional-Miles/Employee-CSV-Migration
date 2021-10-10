package com.spartaglobal.model;

public class DatabaseInfo {

    private final String dbpath = "employees";
    private String tableName = "EMPLOYEE";
    private final String mysql = "jdbc:mysql://localhost:3306/";
    private final String mysqlUser = "root";
    private final String mysqlPass = "SpartaPass!";
    private String[] info = {dbpath,tableName,mysql,mysqlUser,mysqlPass};

    public String[] getInfo() {
        return info;
    }

    public void setInfo(String[] info) {
        this.info = info;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

}
