package com.codingf.update;

import java.sql.*;
import java.util.ResourceBundle;

public class Update {
    public static void Update(String nom, int nbChamps) {
        String updateSql = "UPDATE pays SET ville = ? WHERE id = ?";

<<<<<<< HEAD:src/src/main/java/update/Update.java
    ResourceBundle bundle = ResourceBundle.getBundle("db");
        try (Connection connection = DriverManager.getConnection(bundle.getString("db.host"), bundle.getString("db.user"), bundle.getString("db.pass"))) {
=======
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        try (Connection connection = DriverManager.getConnection("db.host", "db.user", "db.pass")) {
>>>>>>> Alex:src/src/main/java/com/codingf/update/Update.java
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
