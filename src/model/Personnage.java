package model;

public class Personnage {
    private String nom;
    private int pointsDeVie;
    private int force;

    public Personnage(String nom, int pointsDeVie, int force) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.force = force;
    }

    public void attaquer() {
        // Logique de l'attaque
        System.out.println(nom + " attaque !");
    }

    public void defendre() {
        // Logique de la défense
        System.out.println(nom + " se défend !");
    }
}
