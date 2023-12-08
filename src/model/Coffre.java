package model;

import java.util.Random;

public class Coffre implements Interactable {

    private Arme arme;
    private int nombrePieces;

    public Coffre() {
        // Créer une épée de rareté "commun"
        this.arme = new Arme("Épée", Arme.Rarete.COMMUN);
        // Définir un nombre aléatoire de pièces entre 1 et 10
        this.nombrePieces = new Random().nextInt(10) + 1;
    }

    @Override
    public void interact(Personnage personnage) {
        System.out.println(personnage.getNom() + " ouvre le coffre...");

        // Le joueur récupère l'arme et les pièces du coffre
        donnerArme(personnage);
        donnerPieces(personnage);
    }

    private void donnerArme(Personnage personnage) {
        try {
            System.out.println("Vous avez trouvé une " + arme.getNom() + " de rareté " + arme.getRarete() + " !");
            personnage.setArme(arme);
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération de l'arme : " + e.getMessage());
        }
    }

    private void donnerPieces(Personnage personnage) {
        try {
            System.out.println("Vous avez récupéré " + nombrePieces + " pièces.");
            ((Joueur) personnage).ajouterPieces(nombrePieces);
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des pièces : " + e.getMessage());
        }
    }
}
