package model;

public class EnnemiGuerrier extends Ennemi {

    // Constructeur
    public EnnemiGuerrier(String nom, int pointsDeVie, int force) {
        super(nom, pointsDeVie, force);
        genererArmeAleatoire();
    }

    // Méthode pour générer une arme aléatoire
    private void genererArmeAleatoire() {
        double randomValue = Math.random();
        if (randomValue < 0.5) {
            setArme(new Arme("Épée tranchante", genererRareteAleatoire()));
        } else {
            setArme(new Arme("Massue", genererRareteAleatoire()));
        }
    }

    // Méthode pour générer une rareté aléatoire
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
