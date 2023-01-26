package com.codingf.menus;

import java.sql.SQLException;
import java.util.Scanner;

import com.codingf.delete.Delete;
import com.codingf.read.Read;
public class Menus {
    public static void MenuPrincipal() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Choisissez une table dans laquelle vous voulez aller\n" +
                "\n[1] Actor \n" +
                "[2] Actor_info\n" +
                "[3] Address\n" +
                "[4] Category\n" +
                "[5] City\n" +
                "[6] Country\n" +
                "[7] Customer\n" +
                "[8] Customer_List\n" +
                "[9] Film\n" +
                "[10] Film_Actor\n" +
                "[11] Film_Category\n" +
                "[12] Film_List\n" +
                "[13] Film_Text\n" +
                "[14] Inventory\n" +
                "[15] Language\n" +
                "[16] Nicer_But_Slower_Film_List\n" +
                "[17] Payment\n" +
                "[18] Rental\n" +
                "[19] Sales_by_Film_Category\n" +
                "[20] Sales_by_Store\n" +
                "[21] Staff\n" +
                "[22] Staff_List\n" +
                "[23] Store\n" +
                "[24] Exit\n");
        boolean repeat = false;
        while (!repeat){
            System.out.print("\nEntrez votre choix : ");
            String choix = input.next();
            int choixMenuTable = 0;
            try {
                choixMenuTable = Integer.parseInt(choix);
                if (choixMenuTable > 0 && choixMenuTable <= 24) {
                    repeat = true;
                } else {
                    System.err.println("Vous n'avez pas pris un des choix disponible\n");
                }
            } catch (Exception e) {
                System.err.println("Vous n'avez pas rentré un nombre, veuillez réessayer\n");
            }
            String nom = "";
            int nbChamps = 0;
            int nbChampsTotal = 0;
            if (choixMenuTable == 1) {
                nom = "actor";
                nbChamps = 2;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 2) {
                nom = "actor_info";
                nbChamps = 2;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 3) {
                nom = "address";
                nbChamps = 5;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 4) {
                nom = "category";
                nbChamps = 1;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 5) {
                nbChamps = 1;
                nom = "city";
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 6) {
                nom = "country";
                nbChamps = 1;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 7) {
                nom = "customer";
                nbChamps = 3;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 8) {
                nom = "customer_list";
                nbChamps = 6;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 9) {
                nom = "film";
                nbChamps = 4;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 10) {
                nom = "film_actor";
                nbChamps = 0;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 11) {
                nom = "film_category";
                nbChamps = 0;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 12) {
                nom = "film_list";
                nbChamps = 6;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 13) {
                nom = "film_text";
                nbChamps = 2;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 14) {
                nom = "inventory";
                nbChamps = 0;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 15) {
                nom = "language";
                nbChamps = 1;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 16) {
                nom = "nicer_but_slower_film_list";
                nbChamps = 6;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 17) {
                nom = "payment";
                nbChamps = 1;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 18) {
                nom = "rental";
                nbChamps = 0;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 19) {
                nom = "sales_by_film_category";
                nbChamps = 0;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 20) {
                nom = "sales_by_store";
                nbChamps = 0;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 21) {
                nom = "staff";
                nbChamps = 4;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 22) {
                nom = "staff_list";
                nbChamps = 5;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 23) {
                nom = "store";
                nbChamps = 0;
                MenuOperations(nom, nbChamps);
            } else if (choixMenuTable == 24){
                System.out.println("\nAu plaisir de vous revoir prochainement");
                System.exit(0);
            }
        }
    }
    public static void MenuOperations(String nom, int nbChamps) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("\nQue voulez-vous faire dans la table " + nom + "?\n" +
                "\n[1] Créer un élément \n" +
                "[2] Consulter la table \n" +
                "[3] Modifier un élément \n" +
                "[4] Supprimer un élément \n" +
                "[5] Retourner en arrière\n");
        boolean repeat = false;
        while (!repeat) {
            System.out.print("\nEntrez votre choix : ");
            String choix = input.next();
            int choixOperation = 0;
            try {
                choixOperation = Integer.parseInt(choix);
                if (choixOperation > 0 && choixOperation <= 5){
                    repeat = true;
                } else {
                    System.err.println("Vous n'avez pas pris un des choix disponible\n");
                }
            } catch (Exception e){
                System.err.println("Vous n'avez pas rentré un nombre, veuillez réessayer\n");
            }
            if (choixOperation == 1) {
                System.out.println("Créer");
            } else if (choixOperation == 2) {
                Read.Read(nom);
                MenuOperations(nom, nbChamps);
            } else if (choixOperation == 3) {
                System.out.println("Modifier");
            } else if (choixOperation == 4) {
                Delete.Delete(nom);
                MenuOperations(nom, nbChamps);
            } else if (choixOperation == 5) {
                MenuPrincipal();
            }
        }
    }
}
