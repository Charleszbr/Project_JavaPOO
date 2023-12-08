
package model;

public class Potion extends ObjetDuJeu implements Interactable {
    private int soin;



    public Potion(String nom, int soin) {
        super(nom);
        this.soin = soin;
    }

    public int getSoin() {
        return soin;
    }

    @Override
    public void interact(Personnage personnage) {
        if (personnage instanceof Joueur) {
            Joueur joueur = (Joueur) personnage;
            joueur.ajouterObjet(this); // Ajout de la potion à l'inventaire du joueur
            System.out.println(joueur.getNom() + " a acheté une potion de soin.");
            joueur.retirerPieces(25); // Retirer 25 pièces du joueur après l'achat
        } else {
            System.out.println("Seul le joueur peut interagir avec cette potion.");
        }
    }
}
