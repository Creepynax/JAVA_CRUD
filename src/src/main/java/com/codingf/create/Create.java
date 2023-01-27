package com.codingf.create;

import com.codingf.connexiondb.ConnexionDB;

import java.sql.*;
import java.util.Scanner;



public class Create {
    public static void Create(String nom, String[] TotalChamps, String[] nomChamps) throws SQLException {
        if (nom.equals("film_actor") || nom.equals("inventory") || nom.equals("strore") || nom.equals("film_category")) {
            System.out.println("\nNous sommes navrés, vous ne pouvez pas créer de nouveaux champs dans cette table");
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
            StringBuilder values = new StringBuilder("`" + nom + "_id`");
            StringBuilder donneesValues = new StringBuilder("NULL");

            for (int j = 1; j < TotalChamps.length; j++) {
                if (TotalChamps[j] == "?") {
                    System.out.print("\nEntrez la valeur de la donnée [" + nomChamps[j] + "] : ");

                    // récupère la valeur que l'utilisateur a rentrée
                    String choix = string.next();
                    donneesValues.append(", '").append(choix).append("'");
                    values.append(", `").append(nomChamps[j]).append("`");

                } else if (TotalChamps[j] == "CURRENT_TIMESTAMP") {
                    donneesValues.append(", ").append(TotalChamps[j]);
                    values.append(", `").append(nomChamps[j]).append("`");

                } else if (TotalChamps[j] == "NULL"){
                    donneesValues.append(", ").append(TotalChamps[j]);
                    values.append(", `").append(nomChamps[j]).append("`");

                } else {
                    donneesValues.append(", ").append(TotalChamps[j]);
                    values.append(", `").append(nomChamps[j]).append("`");
                }
            }
            try {
                stmt.execute("INSERT INTO `" + nom + "` (" + values + ") VALUES (" + donneesValues + ");");
                    System.out.println("\nVotre champ a bien été crée dans la table " + nom);
            } catch (SQLIntegrityConstraintViolationException e) {
                System.out.println("\nVotre champ n'a pas pu être créée dans la table " + nom + ", nous somme désolé");
            }
        }
    }
}
