package update;

import java.sql.*;
import java.util.ResourceBundle;

public class Update {
    static String updateSql = "UPDATE pays SET ville = ? WHERE id = ?";
    public static void Update() {

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
