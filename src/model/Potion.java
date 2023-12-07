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
            joueur.gainHealthPoints(soin);
            System.out.println(joueur.getNom() + " a utilisé une potion et a récupéré " + soin + " points de vie.");
            // Ajoutez ici d'autres logiques spécifiques à l'interaction avec la potion
        } else {
            System.out.println("Seul le joueur peut interagir avec cette potion.");
        }
    }
}
