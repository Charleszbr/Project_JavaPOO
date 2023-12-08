package model;

import java.util.Scanner;

public class Combat {

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

    private static void tourJoueur(Joueur joueur, Ennemi ennemi, Scanner scanner) {
        System.out.println("\n=== Tour du Joueur ===");
        System.out.println("1. Attaquer");
        System.out.println("2. Se Défendre");
        System.out.print("Choisissez une action : ");

        int choixAction = scanner.nextInt();

        switch (choixAction) {
            case 1:
                joueur.attaquer(ennemi);
                break;
            case 2:
                joueur.seDefendre();
                break;
            default:
                System.out.println("Action invalide. L'ennemi profite de votre hésitation !");
        }
    }

    private static void tourEnnemi(Joueur joueur, Ennemi ennemi) {
        System.out.println("\n=== Tour de l'Ennemi ===");
        ennemi.attaquer(joueur);
    }

    private static void afficherResultatCombat(Joueur joueur, Ennemi ennemi) {
        if (joueur.estEnVie()) {
            System.out.println("\nFélicitations ! Vous avez survécu au combat.");
        } else {
            System.out.println("\nVous avez été vaincu. Game Over.");
        }
    }
}
