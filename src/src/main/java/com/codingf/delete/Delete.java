package com.codingf.delete;

import java.sql.*;
import java.util.ResourceBundle;

public class Delete {
    public static void Delete(String nom) {

        String deleteSql = "DELETE FROM " + nom + " WHERE id = ?";

        ResourceBundle bundle = ResourceBundle.getBundle("db");
        try (Connection connection = DriverManager.getConnection(bundle.getString("db.host"), bundle.getString("db.user"), bundle.getString("db.pass"))) {
            try (PreparedStatement statement = connection.prepareStatement(deleteSql)) {
                statement.setInt(1, 1);
                int rowsAffected = statement.executeUpdate();
                System.out.println(rowsAffected + " Colonne(s) affecté(s).");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
