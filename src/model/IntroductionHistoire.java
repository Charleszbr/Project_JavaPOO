package model;

import java.util.Scanner;

/**
 * Classe représentant l'introduction de l'histoire et les choix du joueur au début de l'aventure.
 */
public class IntroductionHistoire {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Méthode pour lancer l'introduction de l'histoire et permettre au joueur de choisir son chemin.
     *
     * @param joueur Le joueur qui commence l'aventure.
     */
    public static void lancerIntroduction(Joueur joueur) {
        System.out.println();
        System.out.println("=== La Quête du Héros ===");
        System.out.println("Bienvenue, " + joueur.getNom() + "! Vous êtes prêt à commencer votre aventure.");

        // Choix du Chemin
        System.out.println("\nChoisissez votre chemin :");
        System.out.println("1. Chemin de la Forêt");
        System.out.println("2. Chemin de la Montagne");

        int choixChemin = scanner.nextInt();
        scanner.nextLine();  // Pour consommer la nouvelle ligne

        // Exploration du Chemin choisi
        if (choixChemin == 1) {
            cheminForet(joueur);
        } else if (choixChemin == 2) {
            cheminMontagne(joueur);
        } else {
            System.out.println("Choix invalide. L'aventure s'arrête ici.");
        }
    }

    /**
     * Méthode pour représenter le Chemin de la Forêt avec des événements spécifiques.
     *
     * @param joueur Le joueur qui explore le Chemin de la Forêt.
     */
    private static void cheminForet(Joueur joueur) {
        System.out.println("Vous avez choisi le Chemin de la Forêt.");
        System.out.println("Vous entrez dans la forêt mystique...");

        // Découverte du coffre dans la forêt
        System.out.println("Vous découvrez un vieux coffre dans la forêt !");
        Coffre coffreForet = new Coffre();
        coffreForet.interact(joueur);

        // Rencontre avec l'ennemi dans la forêt
        System.out.println("Soudain, un ennemi apparaît !");
        Ennemi ennemiForet = new Ennemi("Garde de la Forêt", 30, 10);
        Combat.lancerCombat(joueur, ennemiForet, scanner);
    }

    /**
     * Méthode pour représenter le Chemin de la Montagne avec des événements spécifiques.
     *
     * @param joueur Le joueur qui explore le Chemin de la Montagne.
     */
    private static void cheminMontagne(Joueur joueur) {
        System.out.println("Vous avez choisi le Chemin de la Montagne.");
        System.out.println("Vous commencez à gravir les montagnes escarpées...");

        // Ici, vous pouvez ajouter des étapes spécifiques au Chemin de la Montagne.
        // Par exemple, des rencontres, des coffres, etc.
    }

    /**
     * Méthode pour fermer le scanner à la fin de l'exécution du programme.
     */
    public static void fermerScanner() {
        scanner.close();
    }
}
