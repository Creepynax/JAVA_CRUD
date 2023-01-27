package com.codingf.update;

import com.codingf.connexiondb.ConnexionDB;
import com.codingf.read.Read;
import java.sql.*;
import java.util.Scanner;

public class Update {
    public static void Update(String nom, String[] nbTotalChamps, String[] nomChamps) throws SQLException {
        if (nom.equals("film_actor") || nom.equals("inventory") || nom.equals("store") || nom.equals("film_category")) {
            System.out.println("\nNous sommes navrés, vous ne pouvez pas modifier des tuples dans cette table, sans provoquer des problèmes");
        } else {
            Scanner string = new Scanner(System.in);
            Read.Read(nom, nomChamps);

            // fait la connexion à la bdd Sakila
            Connection connection = ConnexionDB.connexionDB();
            Statement stmt = connection.createStatement();

            try {

            } catch (Exception e) {

            }
        }
    }




}
