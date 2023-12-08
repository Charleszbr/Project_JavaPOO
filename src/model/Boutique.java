package model;

import java.util.Scanner;

public class Boutique {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Méthode principale pour afficher le menu de la boutique et traiter les choix de l'utilisateur.
     *
     * @param joueur Le joueur qui interagit avec la boutique.
     */
    public static void boutiqueMenu(Joueur joueur) {
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

    /**
     * Méthode privée pour gérer la logique d'achat des objets dans la boutique.
     *
     * @param joueur Le joueur qui effectue l'achat.
     */
    private static void acheterObjets(Joueur joueur) {
        System.out.println();
        System.out.println("Vous êtes dans la section d'achat.");
        System.out.println("1. Acheter des potions (25 pièces)");

        int choixAchat = scanner.nextInt();
        switch (choixAchat) {
            case 1:
                acheterPotion(joueur);
                break;
            default:
                System.out.println("Option invalide. Veuillez réessayer.");
        }
    }

    /**
     * Méthode privée pour gérer l'achat d'une potion dans la boutique.
     *
     * @param joueur Le joueur qui achète la potion.
     */
    private static void acheterPotion(Joueur joueur) {
        // Vérifiez si le joueur a suffisamment de pièces pour acheter la potion
        if (joueur.getNombrePieces() >= 25) {
            Potion potion = new Potion("Potion de Soin", 25);
            joueur.retirerPieces(25); // Retirez le coût de la potion
            joueur.ajouterPotion(potion);
            System.out.println("Vous avez acheté une potion de soin.");
        } else {
            System.out.println("Fonds insuffisants. Vous n'avez pas assez de pièces pour acheter la potion.");
        }
    }

    /**
     * Méthode privée pour afficher le nombre de pièces du joueur.
     *
     * @param joueur Le joueur dont on vérifie le nombre de pièces.
     */
    private static void verifierNombrePieces(Joueur joueur) {
        System.out.println();
        System.out.println("=== Vérification du Nombre de Pièces ===");
        System.out.println("Nombre de pièces : " + joueur.getNombrePieces());
    }
}
