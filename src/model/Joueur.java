package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe représentant le personnage du joueur.
 */
public class Joueur extends Personnage {
    private int nombrePieces;
    private boolean enDefense = false;
    private List<Potion> potions = new ArrayList<>();
    private List<ObjetDuJeu> inventaire = new ArrayList<>();

    /**
     * Constructeur de la classe Joueur.
     *
     * @param nom          Le nom du joueur.
     * @param pointsDeVie  Les points de vie du joueur.
     * @param force        La force du joueur.
     */
    public Joueur(String nom, int pointsDeVie, int force) {
        super(nom, pointsDeVie, force);
        this.nombrePieces = 0;
        this.enDefense = false;
        this.potions = new ArrayList<>();  // Ajoutez cette ligne
        // Initialiser l'inventaire avec quelques potions (vous pouvez ajuster cela selon vos besoins)
        ajouterObjet(new Potion("Potion de Soin", 25));
    }

    /**
     * Méthode pour obtenir l'inventaire du joueur.
     *
     * @return La liste d'objets dans l'inventaire.
     */
    public List<ObjetDuJeu> getInventaire() {
        return this.inventaire;
    }

    /**
     * Méthode pour utiliser une potion du joueur.
     */
    public void utiliserPotion() {
        if (aDesPotions()) {
            System.out.println("Voici vos potions disponibles :");
            for (int i = 0; i < potions.size(); i++) {
                System.out.println((i + 1) + ". " + potions.get(i).getNom());
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Choisissez le numéro de la potion que vous souhaitez utiliser : ");
            int choixPotion = scanner.nextInt();

            if (choixPotion > 0 && choixPotion <= potions.size()) {
                Potion potion = potions.get(choixPotion - 1);
                gainHealthPoints(potion.getSoin());
                System.out.println("Vous avez utilisé une potion de soin et récupéré " + potion.getSoin() + " points de vie.");
                potions.remove(potion);
            } else {
                System.out.println("Choix invalide.");
            }
        } else {
            System.out.println("Vous n'avez aucune potion à utiliser.");
        }
    }

    /**
     * Méthode pour obtenir la liste des potions dans l'inventaire du joueur.
     *
     * @return La liste des potions.
     */
    public List<Potion> getPotions() {
        List<Potion> potions = new ArrayList<>();
        for (ObjetDuJeu objet : inventaire) {
            if (objet instanceof Potion) {
                potions.add((Potion) objet);
            }
        }
        return potions;
    }

    /**
     * Méthode pour mettre le joueur en position de défense.
     */
    public void seDefendre() {
        this.enDefense = true;
        System.out.println("Vous êtes en position de défense. La prochaine attaque de l'ennemi vous infligera 50% de dégâts.");
    }

    /**
     * Méthode pour ajouter un objet à l'inventaire du joueur.
     *
     * @param objet L'objet à ajouter.
     */
    public void ajouterObjet(ObjetDuJeu objet) {
        inventaire.add(objet);
        System.out.println("Vous avez ajouté " + objet.getNom() + " à votre inventaire.");
    }

    /**
     * Méthode pour ajouter des pièces au nombre total de pièces du joueur.
     *
     * @param montant Le montant à ajouter.
     */
    public void ajouterPieces(int montant) {
        this.nombrePieces += montant;
    }

    /**
     * Méthode pour retirer des pièces du nombre total de pièces du joueur.
     *
     * @param montant Le montant à retirer.
     */
    public void retirerPieces(int montant) {
        if (nombrePieces >= montant) {
            nombrePieces -= montant;
            System.out.println("Vous avez dépensé " + montant + " pièces.");
        } else {
            System.out.println("Fonds insuffisants. Vous n'avez que " + nombrePieces + " pièces.");
        }
    }

    /**
     * Méthode pour ajouter une potion à la liste des potions du joueur.
     *
     * @param potion La potion à ajouter.
     */
    public void ajouterPotion(Potion potion) {
        potions.add(potion);
        System.out.println("Vous avez ajouté " + potion.getNom() + " à votre inventaire de potions.");
    }

    /**
     * Méthode pour obtenir le nombre total de pièces du joueur.
     *
     * @return Le nombre total de pièces.
     */
    public int getNombrePieces() {
        return this.nombrePieces;
    }

    /**
     * Méthode pour vérifier si le joueur a des potions dans son inventaire.
     *
     * @return true si le joueur a des potions, sinon false.
     */
    public boolean aDesPotions() {
        for (ObjetDuJeu objet : inventaire) {
            if (objet instanceof Potion) {
                return true;
            }
        }
        return false;
    }
}
