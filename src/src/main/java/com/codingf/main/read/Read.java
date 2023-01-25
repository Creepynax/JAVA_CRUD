package com.codingf.main.read;

import java.sql.*;
public class Read {

    String url = "jdbc:mysql://localhost:3306/mydatabase";
    String username = "root";
    String password = "password";
    String selectSql = "SELECT * FROM users";
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(selectSql)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    System.out.println("id: " + id + ", name: " + name + ", email: " + email);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
