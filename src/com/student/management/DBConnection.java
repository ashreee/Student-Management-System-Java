package com.student.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/StudentDB";
    private static final String USER = "root";   // Replace with your DB username
    private static final String PASSWORD = "tiger"; // Replace with your DB password

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connected successfully!");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Database connection failed!");
            return null;
        }
    }
}
