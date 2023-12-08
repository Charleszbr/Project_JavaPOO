package model;

public class EnnemiGuerrier extends Ennemi {

    /**
     * Constructeur de la classe EnnemiGuerrier.
     *
     * @param nom         Le nom de l'ennemi guerrier.
     * @param pointsDeVie Les points de vie de l'ennemi guerrier.
     * @param force       La force de l'ennemi guerrier.
     */
    public EnnemiGuerrier(String nom, int pointsDeVie, int force) {
        super(nom, pointsDeVie, force);
        genererArmeAleatoire();
    }

    /**
     * Méthode privée pour générer une arme aléatoire pour l'ennemi guerrier.
     */
    private void genererArmeAleatoire() {
        double randomValue = Math.random();
        if (randomValue < 0.5) {
            setArme(new Arme("Épée tranchante", genererRareteAleatoire()));
        } else {
            setArme(new Arme("Massue", genererRareteAleatoire()));
        }
    }

    /**
     * Méthode privée pour générer une rareté aléatoire pour l'arme de l'ennemi guerrier.
     *
     * @return La rareté générée aléatoirement.
     */
    private Arme.Rarete genererRareteAleatoire() {
        double randomValue = Math.random();
        if (randomValue < 0.2) {
            return Arme.Rarete.COMMUN;
        } else if (randomValue < 0.4) {
            return Arme.Rarete.PEU_COMMUN;
        } else if (randomValue < 0.6) {
            return Arme.Rarete.RARE;
        } else if (randomValue < 0.8) {
            return Arme.Rarete.EPIQUE;
        } else {
            return Arme.Rarete.LEGENDAIRE;
        }
    }

    // Autres méthodes de la classe
}
