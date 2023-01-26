package com.codingf.read;

import com.codingf.menus.Menus;
import com.codingf.connexiondb.ConnexionDB;
import java.sql.*;

public class Read {
    public static void Read(String nom) throws SQLException {
        Connection connection = ConnexionDB.connexionDB();
        Statement stmt = connection.createStatement();

        ResultSet read = stmt.executeQuery("SELECT * FROM " + nom);
        ResultSetMetaData resultMeta = read.getMetaData();

        while(read.next()){
            for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                Object obj = read.getObject(i);
                if(obj == null)
                    System.out.println("null");
                else
                    System.out.println(obj.toString());
            }
            System.out.println("======================================");
        }
    }
}
