package model;

public abstract class ObjetDuJeu implements Interactable {
    protected String nom;

    public ObjetDuJeu(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    // ... autres méthodes et attributs communs aux objets du jeu

    // Méthode de l'interface Interactable
    @Override
    public void interact(Personnage personnage) {
        System.out.println(personnage.getNom() + " interagit avec l'objet " + getNom() + ".");
        // Logique spécifique à l'interaction avec l'objet
    }
}
