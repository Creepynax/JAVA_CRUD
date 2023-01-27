package com.codingf.create;

import com.codingf.connexiondb.ConnexionDB;

import java.sql.*;
import java.util.Scanner;



public class Create {
    public static void Create(String nom, String[] TotalChamps, String[] nomChamps) throws SQLException {
        if (nom.equals("film_actor") || nom.equals("inventory") || nom.equals("strore") || nom.equals("film_category")) {
            System.out.println("Nous sommes navrés, vous ne pouvez pas créer de nouveaux champs dans cette table");
        } else {
            Scanner string = new Scanner(System.in);
            System.out.println("\nVoici un exemple d'un champ de la table " + nom + "\n");

            // fait la connexion à la bdd Sakila
            Connection connection = ConnexionDB.connexionDB();
            Statement stmt = connection.createStatement();

            ResultSet soloRead = stmt.executeQuery("SELECT * FROM " + nom + " WHERE " + nom + "_id = 15");
            ResultSetMetaData resultSoloRead = soloRead.getMetaData();

            while (soloRead.next()) {
                for (int i = 1; i <= resultSoloRead.getColumnCount(); i++) {
                    Object obj = soloRead.getObject(i);
                    if (obj == null) {
                        System.out.println("[" + nomChamps[i-1] + "] " + "null");
                    } else
                        System.out.println("[" + nomChamps[i-1] + "] " + obj.toString());
                }
            }

            System.out.println("\nVous allez devoir rentrer les valeurs des données de votre champ");
            System.out.println("Seul les champs que vous pouvez remplir vous seront demandés");
            String values = " (" + nom + "_id";
            String donneesValues = "(NULL";

            for (int j = 1; j < TotalChamps.length; j++) {
                if (TotalChamps[j] == "?") {
                    System.out.print("\nEntrez la valeur de la donnée [" + nomChamps[j] + "] : ");

                    // récupère la valeur que l'utilisateur a rentrée
                    String choix = string.next();
                    donneesValues += ", " + choix.toString();
                    values += ", " + nomChamps[j];
                } else {
                    donneesValues += ", " + TotalChamps[j].toString();
                    values += ", " + nomChamps[j];
                }
            }
            stmt.execute("INSERT INTO " + nom + values + ") VALUES " + donneesValues + ")");
        }
    }
}
