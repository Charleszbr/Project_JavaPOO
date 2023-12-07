package model;

public class EnnemiGuerrier extends Ennemi {
    private String typeArme;
    private boolean aUtiliseRage;

    public EnnemiGuerrier(String nom, int pointsDeVie, int force, String typeArme) {
        super(nom, pointsDeVie, force);
        this.typeArme = typeArme;
        this.aUtiliseRage = false;
    }

    public void utiliserCompetence() {
        if (!aUtiliseRage) {
            System.out.println(getNom() + " utilise la compétence 'rage' !");
            aUtiliseRage = true;
        } else {
            System.out.println(getNom() + " a déjà utilisé la compétence 'rage' et ne peut plus l'utiliser.");
        }
    }

    public void attaquerAvecRage(Personnage cible) {
        if (aUtiliseRage) {
            int degatsRage = 20;
            System.out.println(getNom() + " attaque avec 'rage' et inflige " + (super.getForce() + degatsRage) + " dégâts à " + cible.getNom() + ".");
            cible.subirDegats(super.getForce() + degatsRage);
            aUtiliseRage = false; // La compétence n'est utilisable qu'une seule fois
        } else {
            // Si la compétence n'a pas été activée, utilisez l'attaque normale
            super.attaquer(cible);
        }
    }
}
