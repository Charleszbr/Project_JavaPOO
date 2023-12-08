package model;

import java.util.Random;

public class Ennemi extends Personnage {
    private int nombrePieces;
    private Arme arme;

    /**
     * Constructeur de la classe Ennemi.
     *
     * @param nom          Le nom de l'ennemi.
     * @param pointsDeVie  Les points de vie de l'ennemi.
     * @param force        La force de l'ennemi.
     */
    public Ennemi(String nom, int pointsDeVie, int force) {
        super(nom, pointsDeVie, force);
        this.nombrePieces = new Random().nextInt(10) + 1;
        this.arme = armeAleatoire();
    }

    /**
     * Méthode pour déclencher l'attaque de l'ennemi contre un joueur.
     *
     * @param joueur Le joueur attaqué par l'ennemi.
     */
    public void attaquer(Joueur joueur) {
        int degatsInfliges = (int) (Math.random() * 21) + 10; // Entre 10 et 30 dégâts
        System.out.println("L'ennemi attaque !");
        joueur.subirDegats(degatsInfliges);
        System.out.println("L'ennemi inflige " + degatsInfliges + " points de dégâts au joueur.");
    }

    /**
     * Getter pour le nombre de pièces que l'ennemi porte.
     *
     * @return Le nombre de pièces.
     */
    public int getNombrePieces() {
        return nombrePieces;
    }

    /**
     * Méthode pour déterminer le nombre de pièces lâchées par l'ennemi lorsqu'il est vaincu.
     *
     * @return Le nombre de pièces lâchées.
     */
    public int lacherPieces() {
        return new Random().nextInt(21) + 10; // Entre 10 et 30 pièces
    }

    /**
     * Méthode privée pour générer une arme aléatoire pour l'ennemi.
     *
     * @return Une arme aléatoire.
     */
    private Arme armeAleatoire() {
        Random random = new Random();
        int choixArme = random.nextInt(2);

        if (choixArme == 0) {
            return new Arme("Massue", Arme.Rarete.COMMUN);
        } else {
            return new Arme("Épée", Arme.Rarete.COMMUN);
        }
    }

    /**
     * Méthode pour gérer les dégâts subis par l'ennemi et afficher un message.
     *
     * @param degats Les dégâts subis par l'ennemi.
     */
    @Override
    public void subirDegats(int degats) {
        super.subirDegats(degats);
        System.out.println("L'ennemi a subi " + degats + " points de dégâts.");
    }

    /**
     * Méthode pour afficher l'arme de l'ennemi.
     */
    public void afficherArme() {
        System.out.println("Arme de l'ennemi : " + arme.getNom() + " (Rareté : " + arme.getRarete() + ")");
    }

    /**
     * Méthode pour vérifier si l'ennemi est en vie.
     *
     * @return true si l'ennemi est en vie, sinon false.
     */
    public boolean estEnVie() {
        return super.estEnVie();
    }

    /**
     * Méthode pour afficher l'état actuel de l'ennemi.
     */
    public void afficherEtat() {
        System.out.println("Nom : " + getNom());
        System.out.println("Points de Vie : " + getPointsDeVie());
        System.out.println("Force : " + getForce());
        afficherArme();
    }
}
