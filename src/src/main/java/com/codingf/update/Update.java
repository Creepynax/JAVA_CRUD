package com.codingf.update;

import java.sql.*;
import java.util.ResourceBundle;
import java.sql.SQLException;

public class Update {
    public static void Update(String nom, int nbChamps) {
        String updateSql = "UPDATE pays SET ville = ? WHERE id = ?";

        ResourceBundle bundle = ResourceBundle.getBundle("db");
        try (Connection connection = DriverManager.getConnection("db.host", "db.user", "db.pass")) {
            try (PreparedStatement statement = connection.prepareStatement(updateSql)) {
                statement.setString(1, "Paris");
                statement.setInt(2, 1);
                int rowsAffected = statement.executeUpdate();
                System.out.println(rowsAffected + " Colonne(s) affecté(s).");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
