package model;

/**
 * Classe représentant un objet générique.
 */
public class Objet {
    private String nom;

    /**
     * Constructeur de la classe Objet.
     *
     * @param nom Le nom de l'objet.
     * @throws IllegalArgumentException Si le nom de l'objet est nul ou vide.
     */
    public Objet(String nom) {
        // Validation que le nom n'est pas nul ou vide
        if (nom != null && !nom.isEmpty()) {
            this.nom = nom;
        } else {
            throw new IllegalArgumentException("Le nom de l'objet ne peut pas être nul ou vide.");
        }
    }

    /**
     * Méthode pour obtenir le nom de l'objet.
     *
     * @return Le nom de l'objet.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode toString pour obtenir une représentation textuelle de l'objet.
     *
     * @return Une chaîne de caractères représentant l'objet.
     */
    @Override
    public String toString() {
        return "Objet{" +
                "nom='" + nom + '\'' +
                '}';
    }

    // Ajoutez d'autres méthodes si nécessaire
}
