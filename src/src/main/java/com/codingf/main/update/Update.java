package com.codingf.main.update;

import java.sql.*;
public class Update {

    String url = "jdbc:mysql://localhost:3306/mydatabase";
    String username = "root";
    String password = "password";
    String updateSql = "UPDATE users SET email = ? WHERE id = ?";
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        try (PreparedStatement statement = connection.prepareStatement(updateSql)) {
            statement.setString(1, "newemail@example.com");
            statement.setInt(2, 1);
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " row(s) affected.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
