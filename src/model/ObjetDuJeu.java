package model;

/**
 * Classe abstraite représentant un objet du jeu.
 */
public abstract class ObjetDuJeu implements Interactable {
    protected String nom;

    /**
     * Constructeur de la classe ObjetDuJeu.
     *
     * @param nom Le nom de l'objet du jeu.
     */
    public ObjetDuJeu(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode pour obtenir le nom de l'objet du jeu.
     *
     * @return Le nom de l'objet du jeu.
     */
    public String getNom() {
        return nom;
    }

    // ... autres méthodes et attributs communs aux objets du jeu

    /**
     * Méthode de l'interface Interactable.
     * Permet au personnage d'interagir avec l'objet du jeu.
     *
     * @param personnage Le personnage qui interagit avec l'objet.
     */
    @Override
    public void interact(Personnage personnage) {
        System.out.println(personnage.getNom() + " interagit avec l'objet " + getNom() + ".");
        // Logique spécifique à l'interaction avec l'objet
    }
}
