package model;

import java.util.Random;

public class Ennemi extends Personnage {
    public Ennemi(String nom, int pointsDeVie, int force) {
        super(nom, pointsDeVie, force);
    }

    public int genererButin() {
        Random rand = new Random();
        int nombreDePieces = rand.nextInt(10) + 1;
        System.out.println(getNom() + " a laissé tomber " + nombreDePieces + " pièces.");
        return nombreDePieces;
    }

    // Autres méthodes et attributs spécifiques à Ennemi
    // Ajoutez ici d'autres fonctionnalités spécifiques à la classe Ennemi
}
