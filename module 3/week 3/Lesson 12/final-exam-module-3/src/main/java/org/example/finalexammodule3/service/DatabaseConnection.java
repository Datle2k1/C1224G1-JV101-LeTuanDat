package org.example.finalexammodule3.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/librarymanager";
    private static final String username = "root";
    private static final String password = "11062001&Dat";

    public DatabaseConnection() {
    }

    public static Connection getConnection()  {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection =  DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }

        return connection;
    }
}
