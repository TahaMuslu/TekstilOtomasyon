package com.teksoto;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public Connection databaseLink;

    public DatabaseConnection() {
        getConnection();
    }

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost/tekstil_otomasyonu";
        String user = "root";
        String password = "65655396129";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }

}
