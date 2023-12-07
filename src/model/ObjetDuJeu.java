package model;

public abstract class ObjetDuJeu {
    protected String nom;

    public ObjetDuJeu(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    // Autres méthodes et attributs communs aux objets du jeu
    // Ajoutez ici d'autres fonctionnalités spécifiques à la classe abstraite ObjetDuJeu
}
