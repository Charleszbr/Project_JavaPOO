package model;

/**
 * Classe représentant une potion dans le jeu.
 */
public class Potion extends ObjetDuJeu implements Interactable {
    private int soin;

    /**
     * Constructeur de la classe Potion.
     *
     * @param nom  Le nom de la potion.
     * @param soin La quantité de soin que la potion fournit.
     */
    public Potion(String nom, int soin) {
        super(nom);
        this.soin = soin;
    }

    /**
     * Méthode pour obtenir la quantité de soin fournie par la potion.
     *
     * @return La quantité de soin.
     */
    public int getSoin() {
        return soin;
    }

    /**
     * Méthode d'interaction avec la potion.
     *
     * @param personnage Le personnage interagissant avec la potion.
     */
    @Override
    public void interact(Personnage personnage) {
        if (personnage instanceof Joueur) {
            Joueur joueur = (Joueur) personnage;
            joueur.ajouterObjet(this); // Ajout de la potion à l'inventaire du joueur
            System.out.println(joueur.getNom() + " a acheté une potion de soin.");
            joueur.retirerPieces(5); // Retirer 5 pièces du joueur après l'achat
        } else {
            System.out.println("Seul le joueur peut interagir avec cette potion.");
        }
    }
}
