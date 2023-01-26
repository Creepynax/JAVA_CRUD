package com.codingf.menus;

import java.util.Scanner;
public class Menus {
    public static void MenuPrincipal() {
        Scanner input = new Scanner(System.in);
        System.out.print("Choisissez une table dans laquelle vous voulez aller\n" +
                "\n[1] Actor \n" +
                "[2] Actor_info\n" +
                "[3] Adress\n" +
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
                if (choixMenuTable == 1 || choixMenuTable == 2 || choixMenuTable == 3 || choixMenuTable == 4 || choixMenuTable == 5 || choixMenuTable == 6 || choixMenuTable == 7 || choixMenuTable == 8 || choixMenuTable == 9 || choixMenuTable == 10
                        || choixMenuTable == 11 || choixMenuTable == 12 || choixMenuTable == 13 || choixMenuTable == 14 || choixMenuTable == 15 || choixMenuTable == 16 || choixMenuTable == 17 || choixMenuTable == 18 || choixMenuTable == 19 || choixMenuTable == 20
                        || choixMenuTable == 21 || choixMenuTable == 22 || choixMenuTable == 23 || choixMenuTable == 24) {
                    repeat = true;
                } else {
                    System.err.println("Vous n'avez pas pris un des choix disponible\n");
                }
            } catch (Exception e) {
                System.err.println("Vous n'avez pas rentré un nombre, veuillez réessayer\n");
            }
            String resultat = "";
            if (choixMenuTable == 1) {
                resultat = "actor";
                MenuOperations(resultat);
            } else if (choixMenuTable == 2) {
                resultat = "actor_info";
                MenuOperations(resultat);
            } else if (choixMenuTable == 3) {
                resultat = "adress";
                MenuOperations(resultat);
            } else if (choixMenuTable == 4) {
                resultat = "category";
                MenuOperations(resultat);
            } else if (choixMenuTable == 5) {
                resultat = "city";
                MenuOperations(resultat);
            } else if (choixMenuTable == 6) {
                resultat = "country";
                MenuOperations(resultat);
            } else if (choixMenuTable == 7) {
                resultat = "customer";
                MenuOperations(resultat);
            } else if (choixMenuTable == 8) {
                resultat = "customer_list";
                MenuOperations(resultat);
            } else if (choixMenuTable == 9) {
                resultat = "film";
                MenuOperations(resultat);
            } else if (choixMenuTable == 10) {
                resultat = "film_actor";
                MenuOperations(resultat);
            } else if (choixMenuTable == 11) {
                resultat = "film_category";
                MenuOperations(resultat);
            } else if (choixMenuTable == 12) {
                resultat = "film_list";
                MenuOperations(resultat);
            } else if (choixMenuTable == 13) {
                resultat = "film_text";
                MenuOperations(resultat);
            } else if (choixMenuTable == 14) {
                resultat = "inventory";
                MenuOperations(resultat);
            } else if (choixMenuTable == 15) {
                resultat = "language";
                MenuOperations(resultat);
            } else if (choixMenuTable == 16) {
                resultat = "nicer_but_slower_film_list";
                MenuOperations(resultat);
            } else if (choixMenuTable == 17) {
                resultat = "payment";
                MenuOperations(resultat);
            } else if (choixMenuTable == 18) {
                resultat = "rental";
                MenuOperations(resultat);
            } else if (choixMenuTable == 19) {
                resultat = "sales_by_film_category";
                MenuOperations(resultat);
            } else if (choixMenuTable == 20) {
                resultat = "sales_by_store";
                MenuOperations(resultat);
            } else if (choixMenuTable == 21) {
                resultat = "staff";
                MenuOperations(resultat);
            } else if (choixMenuTable == 22) {
                resultat = "staff_list";
                MenuOperations(resultat);
            } else if (choixMenuTable == 23) {
                resultat = "store";
                MenuOperations(resultat);
            } else if (choixMenuTable == 24){
                System.out.println("\nAu plaisir de vous revoir prochainement");
                System.exit(0);
            }
        }
    }
    public static void MenuOperations(String resultat){
        Scanner input = new Scanner(System.in);
        System.out.print("\nQue voulez-vous faire dans la table " + resultat + "?\n" +
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
                if (choixOperation == 1 || choixOperation == 2 || choixOperation == 3 || choixOperation == 4 || choixOperation == 5){
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
                System.out.println("Consulter");
            } else if (choixOperation == 3) {
                System.out.println("Modifier");
            } else if (choixOperation == 4) {
                System.out.println("Supprimer");
            } else if (choixOperation == 5) {
                MenuPrincipal();
            }
        }
    }
}
