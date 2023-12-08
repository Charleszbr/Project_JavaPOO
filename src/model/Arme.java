package model;

public class Arme {
    private String nom;
    private int degats;
    private Rarete rarete;

    /**
     * Constructeur de la classe Arme.
     *
     * @param nom    Le nom de l'arme.
     * @param rarete La rareté de l'arme (enum Rarete).
     * @throws IllegalArgumentException Si le nom de l'arme est nul ou vide.
     */
    public Arme(String nom, Rarete rarete) {
        // Validation que le nom n'est pas nul ou vide
        if (nom != null && !nom.isEmpty()) {
            this.nom = nom;
        } else {
            throw new IllegalArgumentException("Le nom de l'arme ne peut pas être nul ou vide.");
        }
        this.rarete = rarete;
        this.degats = assignerDegats(rarete);
    }

    /**
     * Méthode privée pour assigner des dégâts basés sur la rareté de l'arme.
     *
     * @param rarete La rareté de l'arme.
     * @return Le nombre de dégâts assignés.
     */
    private int assignerDegats(Rarete rarete) {
        switch (rarete) {
            case COMMUN:
                return 10;
            case PEU_COMMUN:
                return 20;
            case RARE:
                return 30;
            case EPIQUE:
                return 40;
            case LEGENDAIRE:
                return 50;
            default:
                return 0;
        }
    }

    /**
     * Méthode pour améliorer la rareté et les dégâts de l'arme.
     */
    public void ameliorerArme() {
        if (rarete.ordinal() < Rarete.LEGENDAIRE.ordinal()) {
            rarete = Rarete.values()[rarete.ordinal() + 1];
            degats += 10;
            System.out.println("Arme améliorée ! Nouvelle rareté : " + rarete + ", Nouveaux dégâts : " + degats);
        } else {
            System.out.println("L'arme est déjà à la rareté maximale (LÉGENDAIRE).");
        }
    }

    // ... autres méthodes et attributs spécifiques à Arme

    /**
     * Getter pour le nom de l'arme.
     *
     * @return Le nom de l'arme.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter pour le nom de l'arme avec validation.
     *
     * @param nom Le nouveau nom de l'arme.
     * @throws IllegalArgumentException Si le nouveau nom est nul ou vide.
     */
    public void setNom(String nom) {
        // Validation que le nom n'est pas nul ou vide
        if (nom != null && !nom.isEmpty()) {
            this.nom = nom;
        } else {
            throw new IllegalArgumentException("Le nom de l'arme ne peut pas être nul ou vide.");
        }
    }

    /**
     * Getter pour la rareté de l'arme.
     *
     * @return La rareté de l'arme.
     */
    public Rarete getRarete() {
        return rarete;
    }

    /**
     * Setter pour la rareté de l'arme.
     *
     * @param rarete La nouvelle rareté de l'arme.
     */
    public void setRarete(Rarete rarete) {
        this.rarete = rarete;
    }

    /**
     * Getter pour les dégâts de l'arme.
     *
     * @return Le nombre de dégâts de l'arme.
     */
    public int getDegats() {
        return degats;
    }

    /**
     * Setter pour les dégâts de l'arme.
     *
     * @param degats Le nouveau nombre de dégâts de l'arme.
     */
    public void setDegats(int degats) {
        this.degats = degats;
    }

    // Énumération pour les raretés d'arme
    public enum Rarete {
        COMMUN, PEU_COMMUN, RARE, EPIQUE, LEGENDAIRE
    }
}
