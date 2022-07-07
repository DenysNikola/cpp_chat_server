package com.company;

import java.sql.*;

public class DB {
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "cpp_db";
    private final String LOGIN = "root";
    private final String PASS = "";

    private Connection dbConn = null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn;
    }

    public void clearAll(String name)throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM `names` WHERE `names`.`name` = (?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, name);

        prSt.executeUpdate();
    }

    public void clearAll2(String name)throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM `names`";
        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
//        prSt.setString(1, name);

        prSt.executeUpdate();
    }

}
