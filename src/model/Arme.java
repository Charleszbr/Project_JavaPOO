package model;

public class Arme {
    private String nom;
    private int degats;
    private Rarete rarete;

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        // Validation que le nom n'est pas nul ou vide
        if (nom != null && !nom.isEmpty()) {
            this.nom = nom;
        } else {
            throw new IllegalArgumentException("Le nom de l'arme ne peut pas être nul ou vide.");
        }
    }

    public Rarete getRarete() {
        return rarete;
    }

    public void setRarete(Rarete rarete) {
        this.rarete = rarete;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    // Énumération pour les raretés d'arme
    public enum Rarete {
        COMMUN, PEU_COMMUN, RARE, EPIQUE, LEGENDAIRE
    }
}
