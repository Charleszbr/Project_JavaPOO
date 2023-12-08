package model;

public class Personnage {
    private String nom;
    private int pointsDeVie;
    private int force;
    private Arme arme;

    // Constructeur avec validation des valeurs initiales
    public Personnage(String nom, int pointsDeVie, int force) {
        this.nom = nom;
        // Validation des valeurs initiales
        this.pointsDeVie = Math.max(pointsDeVie, 0);
        this.force = Math.max(force, 0);
    }

    public void gainHealthPoints(int points) {
        // Logique pour augmenter les points de vie du personnage
        this.setPointsDeVie(this.getPointsDeVie() + points);
        System.out.println();
        System.out.println("Le personnage a gagné " + points + " points de vie.");
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public boolean estEnVie() {
        return pointsDeVie > 0;
    }

    public String getNom() {
        return nom;
    }

    public int getForce() {
        return force;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public Arme getArme() {
        return arme;
    }

    public void attaquer(Personnage cible) {
        attaquer(cible, 0); // Appel de la méthode avec un bonus de 0
    }

    public void attaquer(Personnage cible, int bonus) {
        int degats = force + bonus;
        System.out.println(getNom() + " attaque " + cible.getNom() + " avec " + (bonus > 0 ? "un bonus de " + bonus + " points de dégâts." : "une attaque normale."));
        cible.subirDegats(degats);
    }

    public void attaquer(ObjetDuJeu objet) {
        System.out.println(getNom() + " interagit avec l'objet " + objet.getNom() + ".");
        if (objet instanceof Interactable) {
            ((Interactable) objet).interact(this);
        }
    }

    public void subirDegats(int degats) {
        pointsDeVie -= degats;
        // Validation pour éviter des points de vie négatifs
        pointsDeVie = Math.max(pointsDeVie, 0);
        System.out.println(getNom() + " subit " + degats + " dégâts.");
        if (!estEnVie()) {
            System.out.println(getNom() + " est vaincu.");
        }
    }

    // ... autres méthodes et attributs
}
