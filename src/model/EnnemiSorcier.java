package model;

public class EnnemiSorcier extends Ennemi {
    private String typeSort;

    public EnnemiSorcier(String nom, int pointsDeVie, int force, String typeSort) {
        super(nom, pointsDeVie, force);
        this.typeSort = typeSort;
    }

    public void lancerSort() {
        System.out.println(super.getNom() + " lance un sort magique.");
    }
}
