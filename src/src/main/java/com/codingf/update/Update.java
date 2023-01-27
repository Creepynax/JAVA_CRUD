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
            System.out.println("\nVoici un exemple d'un tuple de la table " + nom);
            Read.Read(nom, nomChamps);

            // fait la connexion à la bdd Sakila
            Connection connection = ConnexionDB.connexionDB();
            Statement stmt = connection.createStatement();

            int choixID = 0;
            boolean repeatID = false;
            while (!repeatID){
                System.out.print("\nEntrez l'id du tuple que vous voulez modifier : ");
                String choix = string.next();
                try {
                    choixID = Integer.parseInt(choix);
                    if (choixID > 0 && choixID <= 5000) {
                        repeatID = true;
                    } else {
                        System.err.println("Vous n'avez pas pris un des choix disponible\n");
                    }
                } catch (Exception e) {
                    System.err.println("Vous n'avez pas rentré un nombre, veuillez réessayer\n");
                }
            }

            System.out.println("\nVoici les champs qu'il est possible de modifier");
            for (int i = 1; i < nomChamps.length; i++){
                if (nbTotalChamps[i] == "?"){
                    System.out.println("[" + i + "]" + nomChamps[i]);
                }
            }

            int choixModif = 0;
            boolean repeatModif = false;
            while (!repeatModif){
                System.out.print("\nEntrez le numéro du champ que vous voulez modifier : ");
                String choix = string.next();
                try {
                    choixModif = Integer.parseInt(choix);
                    if (choixModif > 0 && choixModif <= nomChamps.length) {
                        repeatModif = true;
                    } else {
                        System.err.println("Vous n'avez pas pris un des choix disponible\n");
                    }
                } catch (Exception e) {
                    System.err.println("Vous n'avez pas rentré un nombre, veuillez réessayer\n");
                }
            }
            Object choixValeur = "";
            System.out.print("\nVeuillez rentrer la valeur du champ " + nomChamps[choixModif] + ": ");
            choixValeur = string.next();

            try {
                stmt.execute("UPDATE`" + nom + "` SET `" + nomChamps[choixModif] + "` = '" + choixValeur + "' WHERE `" + nomChamps + "` = " + choixID + ";");
                System.out.println("\nVotre champ a bien été modifié dans le tuple avec l'id égale à " + choixID);
            } catch (Exception e) {
                System.out.println("\nVotre champ n'a pas pu être modifiée dans le tuple avec l'id égale à " + choixID);
            }
            // ferme-les connections
            stmt.close();
            connection.close();
        }
    }
}
