package com.codingf.connexiondb;

import java.sql.*;
import java.util.ResourceBundle;
public class ConnexionDB {

    // méthode qui fait toute la liaison à la page de donnée Sakila
    // la méthode ne prend pas de paramètre et renvoie connection qui permet de faire une connexion à la base de donnée
    public static Connection connexionDB() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("Errorloadingdriver");
            System.exit(-1);
        }

        ResourceBundle bundle = ResourceBundle.getBundle("db");

        ///URL de connexion
        String host = bundle.getString("db.host");
        String dbName= bundle.getString("db.dbase");
        String dbport= bundle.getString("db.port");
        int port =3306;
        String URL ="jdbc:mysql://"+host +":"+port +"/"+dbName;

        String username="root";
        String password="";

        Connection connection = DriverManager.getConnection(URL,username,password);
        return connection;
    }
}
