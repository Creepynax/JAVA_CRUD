package com.codingf.menus;

import java.sql.SQLException;
import java.util.Scanner;

import com.codingf.create.Create;
import com.codingf.delete.Delete;
import com.codingf.read.Read;
public class Menus {

    // méthode MenuPrincipal qui ne prend pas d'argument et ne renvoie rien
    // et permet à l'utilisateur de choisir la table qu'il veut
    public static void MenuPrincipal() throws SQLException {
        Scanner input = new Scanner(System.in);

        // affiche toutes les tables disponibles à l'utilisateur
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

        // boucle qui se répète tant que l'utilisateur n'a pas rentré une valeur correcte
        while (!repeat){
            System.out.print("\nEntrez votre choix : ");

            // récupère la valeur entrée par l'utilisateur
            String choix = input.next();
            int choixMenuTable = 0;

            // vérifie que la valeur rentrée par l'utilisateur est correcte
            // si oui, on sort de la boucle
            // sinon, on affiche un message d'erreur à l'utilisateur et on recommence la boucle
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

            // affecte, en fonction du choix de l'utilisateur,
            // le nom de la table
            // ainsi que le nombre de champs qui peuvent être changées dans cette table
            String nom = "";
            String[] nomChamps = {""};
            String[] nbTotalChamps = {""};
            if (choixMenuTable == 1) {
                nom = "actor";
                nomChamps = new String[]{"actor_id", "first_name", "last_name", "last_update"};
                nbTotalChamps = new String[]{"NULL", "?", "?", "CURRENT_TIMESTAMP"};
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 2) {
                nom = "actor_info";
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 3) {
                nom = "address";
                nomChamps = new String[]{"address_id", "address", "address2", "district", "city_id", "postal_code", "phone", "location", "last_update"};
                nbTotalChamps = new String[]{"NULL","?","NULL","?","1","?","?","0x0000AHDCN10100000009C3802557204DC0B75CA21FB25C41C0","CURRENT_TIMESTAMP"};
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 4) {
                nom = "category";
                nomChamps = new String[]{"category_id", "name", "last_update"};
                nbTotalChamps = new String[]{"NULL","?","CURRENT_TIMESTAMP"};
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 5) {
                nom = "city";
                nomChamps = new String[]{"city_id", "city", "country_id", "last_update"};
                nbTotalChamps = new String[]{"NULL","?","12","CURRENT_TIMESTAMP"};
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 6) {
                nom = "country";
                nomChamps = new String[]{"country_id", "country", "last_update"};
                nbTotalChamps = new String[]{"NULL","?","CURRENT_TIMESTAMP"};
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 7) {
                nom = "customer";
                nomChamps = new String[]{"customer_id", "store_id", "first_name", "last_in", "email", "address_id", "active", "create_date", "last_update"};
                nbTotalChamps = new String[]{"NULL","1","?","?","?","606","1","CURRENT_TIMESTAMP","CURRENT_TIMESTAMP"};
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 8) {
                nom = "customer_list";
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 9) {
                nom = "film";
                nomChamps = new String[]{"film_id", "title", "description", "release_year", "language_id", "original_language_id", "rental_duration", "rental_rate", "length", "replacement_cost", "rating", "special_features", "last_update"};
                nbTotalChamps = new String[]{"NULL","?","?","?","1","NULL","?","?","?","?","?","?","CURRENT_TIMESTAMP"};
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 10) {
                nom = "film_actor";
                nomChamps = new String[]{"actor_id", "film_id", "last_update"};
                nbTotalChamps = new String[]{"1","1","CURRENT_TIMESTAMP"};
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 11) {
                nom = "film_category";
                nomChamps = new String[]{"film_id", "category_id", "last_update"};
                nbTotalChamps = new String[]{"1","1","CURRENT_TIMESTAMP"};
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 12) {
                nom = "film_list";
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 13) {
                nom = "film_text";
                nomChamps = new String[]{"film_id", "title", "description"};
                nbTotalChamps = new String[]{"NULL","?","?"};
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 14) {
                nom = "inventory";
                nomChamps = new String[]{"inventory_id", "film_id", "store_id", "last_update"};
                nbTotalChamps = new String[]{"NULL","1","2","CURRENT_TIMESTAMP"};
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 15) {
                nom = "language";
                nomChamps = new String[]{"language_id", "name", "last_update"};
                nbTotalChamps = new String[]{"NULL","?","CURRENT_TIMESTAMP"};
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 16) {
                nom = "nicer_but_slower_film_list";
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 17) {
                nom = "payment";
                nomChamps = new String[]{"payment_id", "customer_id", "staff_id", "rental_id", "amount", "payment_date", "last_update"};
                nbTotalChamps = new String[]{"NULL","1","2","2332","?","CURRENT_TIMESTAMP","CURRENT_TIMESTAMP"};
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 18) {
                nom = "rental";
                nomChamps = new String[]{"rental_id", "rental_date", "inventory_id", "customer_id", "return_date", "staff_id", "last_update"};
                nbTotalChamps = new String[]{"NULL","CURRENT_TIMESTAMP","1312","101","CURRENT_TIMESTAMP","1","CURRENT_TIMESTAMP"};
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 19) {
                nom = "sales_by_film_category";
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 20) {
                nom = "sales_by_store";
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 21) {
                nom = "staff";
                nomChamps = new String[]{"staff_id", "first_name", "last_name", "address_id", "picture", "email", "store_id", "active", "username", "password", "last_update"};
                nbTotalChamps = new String[]{"NULL","?","?","45","NULL","?","3","1","?","?","CURRENT_TIMESTAMP"};
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 22) {
                nom = "staff_list";
                MenuOperations(nom, nbTotalChamps, nomChamps);
            } else if (choixMenuTable == 23) {
                nom = "store";
                nomChamps = new String[]{"store_id", "manager_staff_id", "address_id", "last_update"};
                nbTotalChamps = new String[]{"NULL","23","32","CURRENT_TIMESTAMP"};
                MenuOperations(nom, nbTotalChamps, nomChamps);

            // arrête le programme si l'utilisateur choisi cette option
            } else if (choixMenuTable == 24){
                System.out.println("\nAu plaisir de vous revoir prochainement");
                System.exit(0);
            }
        }
    }
    // méthode MenuOperation qui prend en paramètre le nom d'une table et le nombre de champs qui peuvent être modifié dans cette table
    // et permet à l'utilisateur de choisir l'action qu'il veut faire dans la table
    public static void MenuOperations(String nom, String[] nbTotalChamps, String[] nomChamps) throws SQLException {
        Scanner input = new Scanner(System.in);

        // condition qui sépare les views et les tables qui peuvent être modifiées
        if (nom.equals("actor_info") || nom.equals("customer_list") || nom.equals("film_list") || nom.equals("nicer_but_slower_film_list") ||
                nom.equals("sales_by_film_category") || nom.equals("sales_by_store") || nom.equals("staff_list")){
            System.out.print("\nQue voulez-vous faire dans la table " + nom + "?\n" +
                    "\n[1] Consulter la table \n" +
                    "[2] Retourner en arrière\n");

            boolean repeat = false;

            // boucle qui se répète tant que la valeur de l'utilisateur n'est pas bonne
            while (!repeat) {
                System.out.print("\nEntrez votre choix : ");

                // récupère le choix de l'utilisateur
                String choix = input.next();
                int choixOperation = 0;

                // vérifie que l'utilisateur rentre une valeur correcte
                // si oui, on sort de la boucle
                // sinon, on affiche un message d'erreur à l'utilisateur et on recommence la boucle
                try {
                    choixOperation = Integer.parseInt(choix);
                    if (choixOperation > 0 && choixOperation <= 2) {
                        repeat = true;
                    } else {
                        System.err.println("Vous n'avez pas pris un des choix disponible\n");
                    }
                } catch (Exception e) {
                    System.err.println("Vous n'avez pas rentré un nombre, veuillez réessayer\n");
                }
                if (choixOperation == 1) {

                    Read.Read(nom, nomChamps);
                    MenuOperations(nom, nbTotalChamps, nomChamps);

                // permet à l'utilisateur de retourner sur le menu principal
                } else if (choixOperation == 2) {
                    MenuPrincipal();
                }
            }
        } else {
            System.out.print("\nQue voulez-vous faire dans la table " + nom + "?\n" +
                    "\n[1] Créer un élément \n" +
                    "[2] Consulter la table \n" +
                    "[3] Modifier un élément \n" +
                    "[4] Supprimer un élément \n" +
                    "[5] Retourner en arrière\n");
            boolean repeat = false;

            // boucle qui se répète tant que la valeur de l'utilisateur n'est pas bonne
            while (!repeat) {
                System.out.print("\nEntrez votre choix : ");

                // récupère le choix de l'utilisateur
                String choix = input.next();
                int choixOperation = 0;

                // vérifie que l'utilisateur rentre une valeur correcte
                // si oui, on sort de la boucle
                // sinon, on affiche un message d'erreur à l'utilisateur et on recommence la boucle
                try {
                    choixOperation = Integer.parseInt(choix);
                    if (choixOperation > 0 && choixOperation <= 5) {
                        repeat = true;
                    } else {
                        System.err.println("Vous n'avez pas pris un des choix disponible\n");
                    }
                } catch (Exception e) {
                    System.err.println("Vous n'avez pas rentré un nombre, veuillez réessayer\n");
                }

                // emmène l'utilisateur dans la méthode Create de la classe Create
                if (choixOperation == 1) {
                    Create.Create(nom, nbTotalChamps, nomChamps);
                    MenuOperations(nom, nbTotalChamps, nomChamps);

                // emmène l'utilisateur dans la méthode Read de la classe Read
                } else if (choixOperation == 2) {
                    Read.Read(nom, nomChamps);
                    MenuOperations(nom, nbTotalChamps, nomChamps);

                // emmène l'utilisateur dans la méthode Update de la classe Update
                } else if (choixOperation == 3) {
                    System.out.println("Modifier");
                    MenuOperations(nom, nbTotalChamps, nomChamps);

                // emmène l'utilisateur dans la méthode Delete de la classe Delete
                } else if (choixOperation == 4) {
                    Delete.Delete(nom, nomChamps);
                    MenuOperations(nom, nbTotalChamps, nomChamps);

                // permet à l'utilisateur de retourner sur le menu principal
                } else if (choixOperation == 5) {
                    MenuPrincipal();
                }
            }
        }
    }
}
