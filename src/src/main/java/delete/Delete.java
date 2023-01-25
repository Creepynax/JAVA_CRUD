package delete;

import java.sql.*;
import java.util.ResourceBundle;

public class Delete {
    static String deleteSql = "DELETE FROM ville WHERE id = ?";
    public static void Delete() {

        ResourceBundle bundle = ResourceBundle.getBundle("db");
        try (Connection connection = DriverManager.getConnection("db.host", "db.user", "db.pass")) {
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
