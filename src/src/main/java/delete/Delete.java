package delete;

import java.sql.*;
public class Delete {
    String url = "jdbc:mysql://localhost:3306/sakila";
    String username = "root";
    String password = "";

    String deleteSql = "DELETE FROM ville WHERE id = ?";

    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        try (PreparedStatement statement = connection.prepareStatement(deleteSql)) {
            statement.setInt(1, 1);
            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " Colonne(s) affecté(s).");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
