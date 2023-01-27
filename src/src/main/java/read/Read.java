package read;

import java.sql.*;
import java.util.ResourceBundle;

public class Read {
    static String selectSql = "SELECT * FROM pays";

    public static void Read() {

        ResourceBundle bundle = ResourceBundle.getBundle("db");
        try (Connection connection = DriverManager.getConnection(bundle.getString("db.host"), bundle.getString("db.user"), bundle.getString("db.pass"))) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String pays = resultSet.getString("pays");
                        String ville = resultSet.getString("ville");
                        System.out.println("id: " + id + ", pays: " + pays + ", ville: " + ville);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
