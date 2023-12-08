package model;

import java.util.Scanner;

public class Boutique {
    public static void boutiqueMenu(Joueur joueur) {
        Scanner scanner = new Scanner(System.in);
        boolean quitterBoutique = false;

        while (!quitterBoutique) {
            System.out.println();
            System.out.println("=== BOUTIQUE ===");
            System.out.println("1. Acheter des objets");
            System.out.println("2. Vérifier le nombre de pièces");
            System.out.println("3. Revenir au menu principal");
            System.out.print("Choisissez une option : ");

            int choixBoutique = scanner.nextInt();

            switch (choixBoutique) {
                case 1:
                    acheterObjets(joueur);
                    break;
                case 2:
                    verifierNombrePieces(joueur);
                    break;
                case 3:
                    quitterBoutique = true;
                    break;
                default:
                    System.out.println();
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    private static void acheterObjets(Joueur joueur) {
        // Logique d'achat des objets
        System.out.println();
        System.out.println("Vous êtes dans la section d'achat.");
        // Ajoutez ici la logique d'achat d'objets en utilisant les pièces du joueur.
    }

    private static void verifierNombrePieces(Joueur joueur) {
        // Phrase pour vérifier le nombre de pièces (à compléter ultérieurement)
        System.out.println();
        System.out.println("Vous avez actuellement un certain nombre de pièces.");
    }
}
