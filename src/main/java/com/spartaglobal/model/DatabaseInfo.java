package com.spartaglobal.model;

public class DatabaseInfo {

    private String dbpath = "employees";
    private String tableName = "EMPLOYEE";
    private String mysql = "jdbc:mysql://localhost:3306/";
    private String mysqlUser = "root";
    private String mysqlPass = "SpartaPass!";
    private String[] info = {dbpath,tableName,mysql,mysqlUser,mysqlPass};

    public String[] getInfo() {
        return info;
    }

    public void setInfo(String[] info) {
        this.info = info;
    }

    public String getDbpath() {
        return dbpath;
    }

    public void setDbpath(String dbpath) {
        this.dbpath = dbpath;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getMysql() {
        return mysql;
    }

    public void setMysql(String mysql) {
        this.mysql = mysql;
    }

    public String getMysqlUser() {
        return mysqlUser;
    }

    public void setMysqlUser(String mysqlUser) {
        this.mysqlUser = mysqlUser;
    }

    public String getMysqlPass() {
        return mysqlPass;
    }

    public void setMysqlPass(String mysqlPass) {
        this.mysqlPass = mysqlPass;
    }
}
