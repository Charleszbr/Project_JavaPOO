package model;

public class Personnage {
    private String nom;
    public int pointsDeVie;
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
        System.out.println(getNom() + " attaque " + cible.getNom() + " avec une attaque normale.");
        cible.subirDegats(force);
    }

    // Surcharge de la méthode attaquer avec différentes signatures
    public void attaquer(Personnage cible, int bonus) {
        System.out.println(getNom() + " attaque " + cible.getNom() + " avec un bonus de " + bonus + " points de dégâts.");
        cible.subirDegats(force + bonus);
    }

    public void attaquer(ObjetDuJeu objet) {
        System.out.println(getNom() + " interagit avec l'objet " + objet.getNom() + ".");
        // Logique spécifique à l'interaction avec l'objet
        if (objet instanceof Interactable) {
            ((Interactable) objet).interact(this);
        }
    }

    public void subirDegats(int degats) {
        pointsDeVie -= degats;
        System.out.println(getNom() + " subit " + degats + " dégâts.");
    }

    // ... autres méthodes et attributs
}
