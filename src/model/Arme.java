package model;

public class Arme {
    private String nom;
    private int degats;
    private Rarete rarete;

    public Arme(String nom, Rarete rarete) {
        this.nom = nom;
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

    // Autres méthodes et attributs spécifiques à Arme

    public void ameliorerArme() {
        if (rarete.ordinal() < Rarete.LEGENDAIRE.ordinal()) {
            rarete = Rarete.values()[rarete.ordinal() + 1];
            degats += 10;
            System.out.println("Arme améliorée ! Nouvelle rareté : " + rarete + ", Nouveaux dégâts : " + degats);
        } else {
            System.out.println("L'arme est déjà à la rareté maximale (LÉGENDAIRE).");
        }
    }

    // Énumération pour les raretés d'arme
    public enum Rarete {
        COMMUN, PEU_COMMUN, RARE, EPIQUE, LEGENDAIRE
    }
}
