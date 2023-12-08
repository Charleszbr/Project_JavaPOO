package model;

import java.util.Scanner;

public class Combat {

    /**
     * Méthode principale pour lancer un combat entre un joueur et un ennemi.
     *
     * @param joueur  Le joueur participant au combat.
     * @param ennemi  L'ennemi contre lequel le joueur combat.
     * @param scanner Scanner pour la saisie utilisateur pendant le combat.
     */
    public static void lancerCombat(Joueur joueur, Ennemi ennemi, Scanner scanner) {
        System.out.println("Le combat commence !");

        // Boucle de combat
        while (joueur.estEnVie() && ennemi.estEnVie()) {
            // Affichage de l'état actuel du combat
            System.out.println("\n=== État du Combat ===");
            joueur.afficherEtat();
            ennemi.afficherEtat();

            // Tour du joueur
            tourJoueur(joueur, ennemi, scanner);

            // Vérification de la vie après l'attaque du joueur
            if (!ennemi.estEnVie()) {
                System.out.println("\nVous avez vaincu l'ennemi !");
                break;  // Sortir de la boucle si l'ennemi est vaincu
            }

            // Tour de l'ennemi
            tourEnnemi(joueur, ennemi);
        }

        // Afficher le résultat du combat
        afficherResultatCombat(joueur, ennemi);
    }

    /**
     * Méthode privée pour gérer le tour du joueur pendant le combat.
     *
     * @param joueur  Le joueur effectuant l'action.
     * @param ennemi  L'ennemi contre lequel le joueur se bat.
     * @param scanner Scanner pour la saisie utilisateur pendant le tour du joueur.
     */
    private static void tourJoueur(Joueur joueur, Ennemi ennemi, Scanner scanner) {
        System.out.println("\n=== Tour du Joueur ===");
        System.out.println("1. Attaquer");
        System.out.println("2. Se Défendre");
        System.out.println("3. Utiliser une Potion");
        System.out.print("Choisissez une action : ");

        int choixAction = scanner.nextInt();

        switch (choixAction) {
            case 1:
                joueur.attaquer(ennemi);
                break;
            case 2:
                joueur.seDefendre();
                break;
            case 3:
                utiliserPotion(joueur, scanner); // Passer le scanner comme paramètre
                break;
            default:
                System.out.println("Action invalide. L'ennemi profite de votre hésitation !");
        }
    }

    /**
     * Méthode privée pour permettre au joueur d'utiliser une potion pendant le combat.
     *
     * @param joueur  Le joueur utilisant la potion.
     * @param scanner Scanner pour la saisie utilisateur pendant l'utilisation de la potion.
     */
    private static void utiliserPotion(Joueur joueur, Scanner scanner) {
        if (joueur.aDesPotions()) {
            Potion potion = joueur.getPotions().get(0);
            System.out.println("Vous avez " + joueur.getPotions().size() + " potions.");
            System.out.println("Potion disponible : " + potion.getNom() + " (Soin : " + potion.getSoin() + " points de vie)");
            joueur.utiliserPotion();
        } else {
            System.out.println("Vous n'avez aucune potion.");
        }
    }

    /**
     * Méthode privée pour gérer le tour de l'ennemi pendant le combat.
     *
     * @param joueur Le joueur contre lequel l'ennemi attaque.
     * @param ennemi L'ennemi attaquant le joueur.
     */
    private static void tourEnnemi(Joueur joueur, Ennemi ennemi) {
        System.out.println("\n=== Tour de l'Ennemi ===");
        ennemi.attaquer(joueur);
    }

    /**
     * Méthode privée pour afficher le résultat du combat.
     *
     * @param joueur Le joueur participant au combat.
     * @param ennemi L'ennemi contre lequel le joueur a combattu.
     */
    private static void afficherResultatCombat(Joueur joueur, Ennemi ennemi) {
        if (joueur.estEnVie()) {
            System.out.println("\nFélicitations ! Vous avez survécu au combat.");
        } else {
            System.out.println("\nVous avez été vaincu. Game Over.");
        }
    }
}
