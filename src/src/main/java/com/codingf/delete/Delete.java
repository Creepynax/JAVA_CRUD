package com.codingf.delete;

import com.codingf.read.Read;
import com.codingf.connexiondb.ConnexionDB;

import java.sql.*;
import java.util.Scanner;


public class Delete {
    // méthode Delete qui prend en paramètre le nom d'une table et ne renvoie rien
    // et permet à l'utilisateur de supprimer un champ d'une table
    public static void Delete(String nom, String[] nomChamps) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("\nVoici la table " + nom + "\n");

        // affiche l'ensemble de la table rentrée en paramètre
        Read.Read(nom, nomChamps);

        // fait la connexion à la bdd Sakila
        Connection connection = ConnexionDB.connexionDB();
        Statement stmt = connection.createStatement();

        // requête qui renvoyer le nombre total de champs dans la table
        ResultSet count = stmt.executeQuery("SELECT COUNT(*) FROM " + nom);

        int counter = 0;
        if (count.next()) {
            counter = count.getInt(1);
        }

        System.out.println("\nChoisissez l'id de la valeur du tuple que vous voulez supprimer");
        boolean repeat = false;
        int choixDelete = 0;

        // boucle qui va se répéter tant que l'utilisateur n'aura pas entré une valeur valide
        while (!repeat) {
            System.out.print("\nEntrer l'id : ");

            // récupère la valeur que l'utilisateur a rentrée
            String choix = input.next();
            choixDelete = 0;

            // vérifie que la valeur est correcte
            // si oui, elle sort de la boucle,
            // sinon, elle recommence
            try {
                choixDelete = Integer.parseInt(choix);
                if (choixDelete > 0 && choixDelete <= counter) {
                    repeat = true;
                } else {
                    System.err.println("Vous n'avez pas rentré un id correct\n");
                }
            } catch (Exception e) {
                System.err.println("Vous avez rentré autre chose qu'un id\n");
            }
        }

        // vérifie que la requête est possible
        // si oui, elle renvoie un message de succès à l'utilisateur
        // sinon, elle renvoie un message pour lui dire ce qu'il s'est passé
        try {
            stmt.execute("DELETE FROM " + nom + " WHERE "+ nom +"_id = " + choixDelete);
                System.out.println("\nLe tuple dont l'id est " + choixDelete + " a bien été supprimé");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("\nLa tuple dont l'id est " + choixDelete + " n'a pas été supprimé car il est reliée à une autre table");
        }

        // ferme-les connections
        stmt.close();
        connection.close();
    }
}
