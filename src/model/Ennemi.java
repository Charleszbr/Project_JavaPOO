package model;

import java.util.Random;

public class Ennemi {
    private String nom;
    private int pointsDeVie;
    private int force;

    public Ennemi(String nom, int pointsDeVie, int force) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.force = force;
    }

    public void genererButin() {
        Random rand = new Random();
        int nombreDePieces = rand.nextInt(10) + 1;
        System.out.println(nom + " a fait tomber " + nombreDePieces + " pièces.");
        // Ajouter ici la logique pour que le joueur récupère le butin
        // (par exemple, augmenter le nombre de pièces du joueur)
    }

    // Autres méthodes et attributs spécifiques à Ennemi
}
