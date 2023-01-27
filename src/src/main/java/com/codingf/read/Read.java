package com.codingf.read;

import com.codingf.connexiondb.ConnexionDB;

import java.sql.*;

public class Read {

    // méthode Read qui prend en paramètre le nom d'une table et ne renvoie rien
    // et permet à l'utilisateur d'afficher tous les champs de la table rentrée en paramètre
    public static void Read(String nom, String[] nomChamps) throws SQLException {
        System.out.println("\nVoici la table " + nom + "\n");

        // fait la connexion à la bdd Sakila
        Connection connection = ConnexionDB.connexionDB();
        Statement stmt = connection.createStatement();

        // requête qui permet d'afficher l'ensemble de la table rentée en paramètre
        ResultSet read = stmt.executeQuery("SELECT * FROM " + nom);
        ResultSetMetaData resultMeta = read.getMetaData();

        // pour chaque valeur vérifie si la valeur est nul ou non
        // si oui, affiche "null"
        // sinon, affiche la valeur du champ
        while(read.next()){
            for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                Object obj = read.getObject(i);
                if(obj == null)
                    System.out.println("[" + nomChamps[i-1] + "] " + "null");
                else
                    System.out.println("[" + nomChamps[i-1] + "] " + obj.toString());
            }
            System.out.println("======================================");
        }
    }
}
