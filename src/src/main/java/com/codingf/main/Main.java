package com.codingf.main;

import com.codingf.connexiondb.ConnexionDB;
import com.codingf.menus.Menus;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ConnexionDB.connexionDB();
        //System.out.println("\n          Bienvenue dans la base de donnée d'apprentissage Sakila\n");
        //Menus.MenuPrincipal();
    }
}