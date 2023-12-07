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

    public String getNom() {
        return nom;
    }

    public int getForce() {
        return force;
    }

    public void attaquer(Personnage cible) {
        System.out.println(getNom() + " attaque " + cible.getNom() + ".");
        // Logique pour l'attaque normale
    }

    public void subirDegats(int degats) {
        pointsDeVie -= degats;
        System.out.println(getNom() + " subit " + degats + " dégâts.");
    }

    // Autres méthodes et attributs spécifiques à Personnage
}
