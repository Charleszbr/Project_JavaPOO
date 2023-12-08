package model;

import java.util.Random;

public class Ennemi extends Personnage {
    private int nombrePieces;
    private Arme arme;

    public Ennemi(String nom, int pointsDeVie, int force) {
        super(nom, pointsDeVie, force);
        this.nombrePieces = new Random().nextInt(10) + 1;
        this.arme = armeAleatoire();
    }



    public void attaquer(Joueur joueur) {
        int degatsInfliges = (int) (Math.random() * 21) + 10; // Entre 10 et 30 dégâts
        System.out.println("L'ennemi attaque !");
        joueur.subirDegats(degatsInfliges);
        System.out.println("L'ennemi inflige " + degatsInfliges + " points de dégâts au joueur.");
    }



    public int getNombrePieces() {
        return nombrePieces;
    }

    private Arme armeAleatoire() {
        Random random = new Random();
        int choixArme = random.nextInt(2);

        if (choixArme == 0) {
            return new Arme("Massue", Arme.Rarete.COMMUN);
        } else {
            return new Arme("Épée", Arme.Rarete.COMMUN);
        }
    }

    @Override
    public void subirDegats(int degats) {
        super.subirDegats(degats);
        System.out.println("L'ennemi a subi " + degats + " points de dégâts.");
    }

    public void afficherArme() {
        System.out.println("Arme de l'ennemi : " + arme.getNom() + " (Rareté : " + arme.getRarete() + ")");
    }

    public boolean estEnVie() {
        return super.estEnVie();
    }

    public void afficherEtat() {
        System.out.println("Nom : " + getNom());
        System.out.println("Points de Vie : " + getPointsDeVie());
        System.out.println("Force : " + getForce());
        afficherArme();
    }
}
