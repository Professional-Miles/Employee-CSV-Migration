package com.spartaglobal.control;

import java.sql.*;

public class DatabaseValidator {

    public static boolean databaseExists(String[] info){
        ResultSet rs = null;
        boolean result = false;
        try (Connection conn = DriverManager.getConnection(info[2]+info[0],info[3],info[4])) {
            if (conn != null){
                rs = conn.getMetaData().getCatalogs();
                while(rs.next()){
                    String catalogs = rs.getString(1);
                    if(info[0].equals(catalogs)){
                        result = true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean tableExists(String[] info) throws SQLException {
        ResultSet rs = null;
        Connection conn = DriverManager.getConnection(info[2]+info[0],info[3],info[4]);
        if (conn != null) {
            DatabaseMetaData dbm = conn.getMetaData();
            rs = dbm.getTables(null,null,info[1],null);
        }
        return rs.next();
    }




}
