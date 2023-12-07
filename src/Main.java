import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.*;

public class Main {
    public static void main(String[] args) {
        List<Personnage> personnages = new ArrayList<>();
        List<Ennemi> ennemis = new ArrayList<>();
        List<ObjetDuJeu> objets = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        Joueur joueur = null;

        boolean quitter = false;
        while (!quitter) {
            try {
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
                            System.out.println("Veuillez d'abord créer un personnage.");
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
            } catch (Exception e) {
                System.out.println();
                System.out.println("Une erreur s'est produite : " + e.getMessage());
                // Ajoutez ici la logique de gestion des erreurs selon vos besoins
            }
        }
        System.out.println();
        System.out.println("Merci d'avoir joué !");
    }

    private static Joueur creerPersonnage() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.print("Entrez le nom du joueur : ");
            String nom = scanner.nextLine();

            // Points de vie et force fixés à des valeurs prédéfinies
            int pointsDeVie = 100;
            int force = 10;

            return new Joueur(nom, pointsDeVie, force);
        } catch (Exception e) {
            System.out.println();
            System.out.println("Erreur lors de la création du personnage : " + e.getMessage());
            return null;
        }
    }

    private static void lancerPartie(Joueur joueur) {
        try {
            // Implémenter la logique pour lancer une partie
            System.out.println();
            System.out.println("La partie est lancée pour le joueur : " + joueur.getNom());
        } catch (Exception e) {
            System.out.println();
            System.out.println("Erreur lors du lancement de la partie : " + e.getMessage());
        }
    }
}
