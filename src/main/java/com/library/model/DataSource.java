package com.library.model;

// Creating the database connection

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    public static Connection connect() {
        String url = "jdbc:postgresql://localhost:5432/loverary";
        String user = "postgres";
        String password = "etseye123";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to loverary db!");
				
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
		return conn;
    }
}
