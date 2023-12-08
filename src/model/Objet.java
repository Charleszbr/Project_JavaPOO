package model;

public class Objet {
    private String nom;

    public Objet(String nom) {
        // Validation que le nom n'est pas nul ou vide
        if (nom != null && !nom.isEmpty()) {
            this.nom = nom;
        } else {
            throw new IllegalArgumentException("Le nom de l'objet ne peut pas être nul ou vide.");
        }
    }

    public String getNom() {
        return nom;
    }

    // Ajoutez d'autres méthodes si nécessaire

    @Override
    public String toString() {
        return "Objet{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
