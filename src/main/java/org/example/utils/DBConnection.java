package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
    private String host = "localhost";
    private String port = "5432";
    private String databaseName = "postgres";
    private String userName = "postgres";
    private String password = "";

    public Connection getConnection() {
        Connection conn = null;
        try {
         conn = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/"+ databaseName,
                 userName, password);
            System.out.println("I'M IN");
            }catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}

