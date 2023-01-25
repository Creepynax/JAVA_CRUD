package create;

import java.sql.*;
import java.util.ResourceBundle;

public class Create {

    String insertSql = "INSERT INTO sakila (pays, ville) VALUES (?, ?)";

    ResourceBundle bundle = ResourceBundle.getBundle("db");
        try (Connection connection = DriverManager.getConnection("db.host", "db.user", "db.pass")) {
        try (PreparedStatement statement = connection.prepareStatement(insertSql)) {
            statement.setString(1, "France");
            statement.setString(2, "Paris");
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " Colonne(s) affecté(s).");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}