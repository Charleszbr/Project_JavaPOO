import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Personnage> personnages = new ArrayList<>();
        List<Ennemi> ennemis = new ArrayList<>();
        List<ObjetDuJeu> objets = new ArrayList<>();

        Joueur joueur = null;

        boolean quitter = false;
        while (!quitter) {
            try {
                afficherMenuPrincipal();

                int choix = scanner.nextInt();
                scanner.nextLine(); // Pour consommer la nouvelle ligne

                switch (choix) {
                    case 1:
                        joueur = creerPersonnage();
                        break;
                    case 2:
                        lancerPartie(joueur);
                        break;
                    case 3:
                        joueur = chargerPartie("sauvegarde.txt");
                        break;
                    case 4:
                        accederBoutique(joueur);
                        break;
                    case 5:
                        sauvegarderPartie(joueur, "sauvegarde.txt");
                        break;
                    case 6:
                        quitter = true;
                        break;
                    default:
                        System.out.println("Option invalide. Veuillez réessayer.");
                }

            } catch (Exception e) {
                System.out.println("Une erreur s'est produite : " + e.getMessage());
                // Ajoutez ici la logique de gestion des erreurs selon vos besoins
            }
        }
        System.out.println();
        System.out.println("Merci d'avoir joué !");
    }

    private static void afficherMenuPrincipal() {
        System.out.println();
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1. Créer un personnage");
        System.out.println("2. Lancer une partie");
        System.out.println("3. Charger la partie");
        System.out.println("4. Aller dans la boutique");
        System.out.println("5. Sauvegarder la partie");
        System.out.println("6. Quitter le jeu");
        System.out.print("Choisissez une option : ");
    }

    private static Joueur creerPersonnage() {
        try {
            System.out.println();
            System.out.print("Entrez le nom du joueur : ");
            String nom = scanner.nextLine();
            int pointsDeVie = 100;
            int force = 10;

            return new Joueur(nom, pointsDeVie, force);
        } catch (Exception e) {
            System.out.println("Erreur lors de la création du personnage : " + e.getMessage());
            return null;
        }
    }

    private static void lancerPartie(Joueur joueur) {
        if (joueur != null) {
            IntroductionHistoire.lancerIntroduction(joueur);
        } else {
            System.out.println("Veuillez d'abord créer un personnage.");
        }
    }

    private static void accederBoutique(Joueur joueur) {
        Boutique.boutiqueMenu(joueur);
    }

    private static void sauvegarderPartie(Joueur joueur, String cheminFichier) {
        GestionFichier.sauvegarderJoueur(joueur, cheminFichier);
    }

    private static Joueur chargerPartie(String cheminFichier) {
        return GestionFichier.chargerJoueur(cheminFichier);
    }
}
