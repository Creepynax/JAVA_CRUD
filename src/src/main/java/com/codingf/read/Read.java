package com.codingf.read;

import com.codingf.connexiondb.ConnexionDB;
import java.sql.*;

public class Read {
    public static void Read(String nom) {
        String selectSql = "SELECT * FROM " + nom;
    }
}
