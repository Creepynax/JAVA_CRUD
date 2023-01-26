package create;

import java.sql.*;
import java.util.ResourceBundle;

public class Create {

    static String insertSql = "INSERT INTO sakila (pays, ville) VALUES (?, ?)";

    public static void Create() {

        ResourceBundle bundle = ResourceBundle.getBundle("db");
        try (Connection connection = DriverManager.getConnection(bundle.getString("db.host"), bundle.getString("db.user"), bundle.getString("db.pass"))) {
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
}
