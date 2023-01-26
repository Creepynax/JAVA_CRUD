package com.codingf.connexiondb;

import java.sql.*;
import java.util.ResourceBundle;
public class ConnexionDB {
    public static void connexionDB() throws SQLException{
        System.out.println("Application Sakila");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("Errorloadingdriver");
            System.exit(-1);
        }
        System.out.println("Le driver est chargé!!!!!!!!");

        ResourceBundle bundle = ResourceBundle.getBundle("db");

        ///URL de connexion
        String host = bundle.getString("db.host");
        String dbName= bundle.getString("db.dbase");
        String dbport= bundle.getString("db.port");
        int port =3306;
        String URL ="jdbc:mysql://"+host +":"+port +"/"+dbName;

        String username="root";
        String password="";

        Connection connection =
                DriverManager.getConnection(URL,username,password);
        if (connection==null) {
            System.err.println("Erreur de connexion!!!");
        }else {
            System.out.println("connexion etablie");
        }
        DatabaseMetaData dbMetaData=connection.getMetaData();
        String productName=dbMetaData.getDatabaseProductName();
        System.out.println("Database: "+productName);
        String productVersion=dbMetaData.getDatabaseProductVersion();
        System.out.println("Version: "+productVersion);
    }
}
