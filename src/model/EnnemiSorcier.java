package model;

public class EnnemiSorcier extends Ennemi {
    private String typeSort;

    /**
     * Constructeur de la classe EnnemiSorcier.
     *
     * @param nom       Le nom de l'ennemi sorcier.
     * @param pointsDeVie Les points de vie de l'ennemi sorcier.
     * @param force     La force de l'ennemi sorcier.
     * @param typeSort  Le type de sort que l'ennemi sorcier peut lancer.
     */
    public EnnemiSorcier(String nom, int pointsDeVie, int force, String typeSort) {
        super(nom, pointsDeVie, force);
        this.typeSort = typeSort;
    }

    /**
     * Méthode pour simuler le lancement d'un sort par l'ennemi sorcier.
     */
    public void lancerSort() {
        System.out.println(super.getNom() + " lance un sort magique de type " + typeSort + ".");
    }

    /**
     * Getter pour obtenir le type de sort de l'ennemi sorcier.
     *
     * @return Le type de sort.
     */
    public String getTypeSort() {
        return typeSort;
    }
}
