package create;

import java.sql.*;

public class Create {
    String url = "jdbc:mysql://localhost:3306/sakila";
    String username = "root";
    String password = "";
    String insertSql = "INSERT INTO sakila (pays, ville) VALUES (?, ?)";

    try (Connection connection = DriverManager.getConnection(url, username, password)) {
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
