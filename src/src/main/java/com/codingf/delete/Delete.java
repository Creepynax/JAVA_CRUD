package com.codingf.delete;

import com.codingf.read.Read;
import java.sql.*;
import java.util.Scanner;
import com.codingf.connexiondb.ConnexionDB;

public class Delete {
    public static void Delete(String nom) throws SQLException {
        Scanner input = new Scanner(System.in);
        Read.Read(nom);

        Connection connection = ConnexionDB.connexionDB();
        Statement stmt = connection.createStatement();

        ResultSet count = stmt.executeQuery("SELECT COUNT(*) FROM " + nom);

        int counter = 0;
        if (count.next()) {
            counter = count.getInt(1);
        }

        System.out.println("Choisissez l'id de la valeur du champ que vous voulez supprimer");
        boolean repeat = false;
        while (!repeat){
            System.out.print("\nEntrer l'id : ");
            String choix = input.next();
            int choixDelete = 0;
            try {
                choixDelete = Integer.parseInt(choix);
                if (choixDelete > 0 && choixDelete <= counter){
                    repeat = true;
                } else {
                    System.err.println("Vous n'avez pas rentré un id correct\n");
                }
            } catch (Exception e){
                System.err.println("Vous avez rentré autre chose qu'un id\n");
            }
            ResultSet delete = stmt.executeQuery("DELETE FROM " + nom + " WHERE id = " + choixDelete);
        }
    }
}
