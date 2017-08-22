package com.eza.jerseydemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbCon {

    public Connection getConnection() {
        Connection con;

        try {
        	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restfulclient?zeroDateTimeBehavior=convertToNull", "Admin", "123");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
