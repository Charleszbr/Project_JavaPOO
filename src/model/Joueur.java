package model;

public class Joueur extends Personnage {
    private int nombreDePieces;

    public Joueur(String nom, int pointsDeVie, int force) {
        super(nom, pointsDeVie, force);
        this.nombreDePieces = 0;
    }

    public void ramasserButin(Ennemi ennemi) {
        int nombreDePieces = ennemi.genererButin();
        this.nombreDePieces += nombreDePieces;
        System.out.println(getNom() + " a ramassé " + nombreDePieces + " pièces. Total : " + this.nombreDePieces);
    }

    // Autres méthodes et attributs spécifiques à Joueur
    // Ajoutez ici d'autres fonctionnalités spécifiques à la classe Joueur
}
