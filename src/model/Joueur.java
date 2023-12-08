// Dans le fichier Joueur.java
package model;

import java.util.ArrayList;
import java.util.List;

public class Joueur extends Personnage {

    private int nombrePieces;
    private boolean enDefense = false;
    private List<Potion> potions;
    private List<ObjetDuJeu> inventaire = new ArrayList<>();

    public Joueur(String nom, int pointsDeVie, int force) {
        super(nom, pointsDeVie, force);
        this.nombrePieces = 0;
        this.enDefense = false;
        this.potions = new ArrayList<>();
        // Initialiser l'inventaire avec quelques potions (vous pouvez ajuster cela selon vos besoins)
        ajouterPotion(new Potion("Potion de Soin", 25));
    }

    public void seDefendre() {
        this.enDefense = true;
        System.out.println();
        System.out.println("Vous êtes en position de défense. La prochaine attaque de l'ennemi vous infligera 50% de dégâts.");
    }

    public int getNombrePieces() {
        return this.nombrePieces;
    }

    public void ajouterPieces(int montant) {
        this.nombrePieces += montant;
    }

    public void ramasserButin(Ennemi ennemi) {
        int piecesEnnemi = ennemi.getNombrePieces();
        System.out.println("Vous avez récupéré " + piecesEnnemi + " pièces.");
        this.nombrePieces += piecesEnnemi;
    }

    public void ajouterObjet(ObjetDuJeu objet) {
        inventaire.add(objet);
        System.out.println("Vous avez ajouté " + objet.getNom() + " à votre inventaire.");
    }

    @Override
    public void subirDegats(int degats) {
        if (enDefense) {
            degats /= 2;
            enDefense = false;
        }
        super.subirDegats(degats);
        System.out.println("Vous avez subi " + degats + " points de dégâts.");
    }

    public void activerDefense() {
        enDefense = true;
        System.out.println("Vous êtes en position de défense. La prochaine attaque de l'ennemi vous infligera 50% de dégâts.");
    }

    public void utiliserPotion() {
        if (aDesPotions()) {
            Potion potion = potions.get(0);
            gainHealthPoints(potion.getSoin());
            System.out.println("Vous avez utilisé une potion de soin et récupéré " + potion.getSoin() + " points de vie.");
            potions.remove(potion);
        }
    }

    public void ajouterPotion(Potion potion) {
        potions.add(potion);
    }

    public boolean aDesPotions() {
        return !potions.isEmpty();
    }

    public void retirerPieces(int montant) {
        if (nombrePieces >= montant) {
            nombrePieces -= montant;
            System.out.println("Vous avez dépensé " + montant + " pièces.");
        } else {
            System.out.println("Fonds insuffisants. Vous n'avez que " + nombrePieces + " pièces.");
        }
    }

    public void afficherEtat() {
        System.out.println("Nom : " + getNom());
        System.out.println("Points de Vie : " + getPointsDeVie());
        System.out.println("Force : " + getForce());
        System.out.println("Nombre de Pièces : " + getNombrePieces());
    }

    // ... (autres méthodes et attributs de la classe)
}
