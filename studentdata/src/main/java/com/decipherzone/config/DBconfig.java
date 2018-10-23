package com.decipherzone.config;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBconfig {

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useSSL=false", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

