package model;

/**
 * Interface représentant des objets ou entités qui peuvent interagir avec un personnage.
 */
public interface Interactable {

    /**
     * Méthode pour définir l'interaction entre l'objet/entité et un personnage.
     *
     * @param personnage Le personnage avec lequel l'interaction se produit.
     */
    void interact(Personnage personnage);
}
