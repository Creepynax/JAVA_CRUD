package read;

import java.sql.*;
public class Read {

    String url = "jdbc:mysql://localhost:3306/sakila";
    String username = "root";
    String password = "";
    String selectSql = "SELECT * FROM pays";

    try (Connection connection = DriverManager.getConnection(url, username, password)) {
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
