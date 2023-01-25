package com.codingf.main.create;

import java.sql.*;

public class Create {
    String url = "jdbc:mysql://localhost:3306/sakila";
    String username = "root";
    String password = "";
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
}
