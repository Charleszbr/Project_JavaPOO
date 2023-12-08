package model;

/**
 * Classe représentant un personnage du jeu.
 */
public class Personnage {
    private String nom;
    private int pointsDeVie;
    private int force;
    private Arme arme;

    // Constructeur avec validation des valeurs initiales
    public Personnage(String nom, int pointsDeVie, int force) {
        this.nom = nom;
        // Validation des valeurs initiales
        this.pointsDeVie = Math.max(pointsDeVie, 0);
        this.force = Math.max(force, 0);
    }

    /**
     * Méthode pour augmenter les points de vie du personnage.
     *
     * @param points Les points de vie à ajouter.
     */
    public void gainHealthPoints(int points) {
        // Logique pour augmenter les points de vie du personnage
        this.setPointsDeVie(this.getPointsDeVie() + points);
        System.out.println();
        System.out.println("Le personnage a gagné " + points + " points de vie.");
    }

    /**
     * Méthode pour obtenir les points de vie du personnage.
     *
     * @return Les points de vie du personnage.
     */
    public int getPointsDeVie() {
        return pointsDeVie;
    }

    /**
     * Méthode pour définir les points de vie du personnage.
     *
     * @param pointsDeVie Les nouveaux points de vie du personnage.
     */
    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    /**
     * Méthode pour vérifier si le personnage est en vie.
     *
     * @return true si le personnage est en vie, sinon false.
     */
    public boolean estEnVie() {
        return pointsDeVie > 0;
    }

    /**
     * Méthode pour obtenir le nom du personnage.
     *
     * @return Le nom du personnage.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode pour obtenir la force du personnage.
     *
     * @return La force du personnage.
     */
    public int getForce() {
        return force;
    }

    /**
     * Méthode pour définir l'arme du personnage.
     *
     * @param arme L'arme à définir.
     */
    public void setArme(Arme arme) {
        this.arme = arme;
    }

    /**
     * Méthode pour obtenir l'arme du personnage.
     *
     * @return L'arme du personnage.
     */
    public Arme getArme() {
        return arme;
    }

    /**
     * Méthode pour attaquer un autre personnage.
     *
     * @param cible La cible de l'attaque.
     */
    public void attaquer(Personnage cible) {
        attaquer(cible, 0); // Appel de la méthode avec un bonus de 0
    }

    /**
     * Méthode pour attaquer un autre personnage avec un bonus.
     *
     * @param cible La cible de l'attaque.
     * @param bonus Le bonus d'attaque.
     */
    public void attaquer(Personnage cible, int bonus) {
        int degats = force + bonus;
        System.out.println(getNom() + " attaque " + cible.getNom() + " avec " + (bonus > 0 ? "un bonus de " + bonus + " points de dégâts." : "une attaque normale."));
        cible.subirDegats(degats);
    }

    /**
     * Méthode pour attaquer un objet du jeu.
     *
     * @param objet L'objet du jeu à attaquer.
     */
    public void attaquer(ObjetDuJeu objet) {
        System.out.println(getNom() + " interagit avec l'objet " + objet.getNom() + ".");
        if (objet instanceof Interactable) {
            ((Interactable) objet).interact(this);
        }
    }

    /**
     * Méthode pour afficher l'état du personnage.
     */
    public void afficherEtat() {
        System.out.println("Nom : " + getNom());
        System.out.println("Points de Vie : " + getPointsDeVie());
        System.out.println("Force : " + getForce());
    }

    /**
     * Méthode pour faire subir des dégâts au personnage.
     *
     * @param degats Les dégâts à infliger.
     */
    public void subirDegats(int degats) {
        pointsDeVie -= degats;
        // Validation pour éviter des points de vie négatifs
        pointsDeVie = Math.max(pointsDeVie, 0);
        System.out.println(getNom() + " subit " + degats + " dégâts.");
        if (!estEnVie()) {
            System.out.println(getNom() + " est vaincu.");
        }
    }

    // ... autres méthodes et attributs
}
