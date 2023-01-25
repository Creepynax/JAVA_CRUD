package update;

import java.sql.*;
public class Update {

    String url = "jdbc:mysql://localhost:3306/sakila";
    String username = "root";
    String password = "";
    String updateSql = "UPDATE pays SET ville = ? WHERE id = ?";

    try (Connection connection = DriverManager.getConnection(url, username, password)) {
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
