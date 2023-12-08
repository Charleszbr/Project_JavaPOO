package model;

import java.util.Random;

public class Coffre implements Interactable {

    private Arme arme;
    private int nombrePieces;

    /**
     * Constructeur de la classe Coffre.
     * Crée une épée de rareté "commun" et détermine un nombre aléatoire de pièces entre 1 et 10.
     */
    public Coffre() {
        // Créer une épée de rareté "commun"
        this.arme = new Arme("Épée", Arme.Rarete.COMMUN);
        // Définir un nombre aléatoire de pièces entre 1 et 10
        this.nombrePieces = new Random().nextInt(10) + 1;
    }

    /**
     * Méthode d'interaction avec le coffre.
     * Le personnage ouvre le coffre et récupère l'arme et les pièces.
     *
     * @param personnage Le personnage qui interagit avec le coffre.
     */
    @Override
    public void interact(Personnage personnage) {
        System.out.println(personnage.getNom() + " ouvre le coffre...");

        // Le joueur récupère l'arme et les pièces du coffre
        donnerArme(personnage);
        donnerPieces(personnage);
    }

    /**
     * Méthode privée pour donner une arme au personnage.
     *
     * @param personnage Le personnage qui reçoit l'arme.
     */
    private void donnerArme(Personnage personnage) {
        try {
            System.out.println("Vous avez trouvé une " + arme.getNom() + " de rareté " + arme.getRarete() + " !");
            personnage.setArme(arme);
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération de l'arme : " + e.getMessage());
        }
    }

    /**
     * Méthode privée pour donner des pièces au personnage.
     *
     * @param personnage Le personnage qui reçoit les pièces.
     */
    private void donnerPieces(Personnage personnage) {
        try {
            System.out.println("Vous avez récupéré " + nombrePieces + " pièces.");
            ((Joueur) personnage).ajouterPieces(nombrePieces);
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des pièces : " + e.getMessage());
        }
    }
}
