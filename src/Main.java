import java.util.Scanner;
import model.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Joueur joueur = null;

        boolean quitter = false;
        while (!quitter) {
            System.out.println();
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Créer un personnage");
            System.out.println("2. Lancer une partie");
            System.out.println("3. Aller dans la boutique");
            System.out.println("4. Quitter le jeu");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    joueur = creerPersonnage();
                    break;
                case 2:
                    if (joueur != null) {
                        lancerPartie(joueur);
                    } else {
                        System.out.println();
                        System.out.println("Veuillez créer un personnage d'abord.");
                    }
                    break;
                case 3:
                    Boutique.boutiqueMenu(joueur);
                    break;
                case 4:
                    quitter = true;
                    break;
                default:
                    System.out.println();
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
        System.out.println();
        System.out.println("Merci d'avoir joué !");
    }

    private static Joueur creerPersonnage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Entrez le nom du joueur : ");
        String nom = scanner.nextLine();

        // Points de vie et force fixés à des valeurs prédéfinies
        int pointsDeVie = 100;
        int force = 10;

        return new Joueur(nom, pointsDeVie, force);
    }

    private static void lancerPartie(Joueur joueur) {
        // Implémenter la logique pour lancer une partie
        System.out.println();
        System.out.println("La partie est lancée pour le joueur : " + joueur.getNom());
    }
}
