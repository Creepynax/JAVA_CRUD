package com.codingf.main.delete;

import java.sql.*;
public class Delete {
    String url = "jdbc:mysql://localhost:3306/mydatabase";
    String username = "root";
    String password = "password";

    // Create
    String insertSql = "INSERT INTO users (name, email) VALUES (?, ?)";
try (Connection connection = DriverManager.getConnection(url, username, password)) {
        try (PreparedStatement statement = connection.prepareStatement(insertSql)) {
            statement.setString(1, "John Doe");
            statement.setString(2, "johndoe@example.com");
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }





    // Delete
    String deleteSql = "DELETE FROM users WHERE id = ?";
try (Connection connection = DriverManager.getConnection(url, username, password)) {
        try (PreparedStatement statement = connection.prepareStatement(deleteSql)) {
            statement.setInt(1, 1);
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
