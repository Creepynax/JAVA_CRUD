package com.codingf.menus;

import java.util.Scanner;
public class Menus {
    public static void MenuPrincipal() {
        Scanner input = new Scanner(System.in);
        System.out.print("Choisissez une table dans laquelle vous voulez aller\n" +
                "\n[1] City \n" +
                "[2] Country\n" +
                "[3] Exit\n");
        boolean repeat = false;
        while (!repeat){
            System.out.print("\nEntrez votre choix : ");
            String choix = input.next();
            int choixMenuTable = 0;
            try {
                choixMenuTable = Integer.parseInt(choix);
                if (choixMenuTable == 1 || choixMenuTable == 2 || choixMenuTable == 3) {
                    repeat = true;
                } else {
                    System.err.println("Vous n'avez pas pris un des choix disponible\n");
                }
            } catch (Exception e) {
                System.err.println("Vous n'avez pas rentré un nombre, veuillez réessayer\n");
            }
            String resultat = "";
            if (choixMenuTable == 1) {
                resultat = "city";
                MenuOperations(resultat);
            } else if (choixMenuTable == 2) {
                resultat = "country";
                MenuOperations(resultat);
            }
            else if (choixMenuTable == 3){
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
                System.out.println("Création");
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
