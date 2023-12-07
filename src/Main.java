import model.*;

public class Main {
    public static void main(String[] args) {
        // Testons les classes de base ici
        Personnage joueur = new Personnage("Joueur", 100, 20);
        Ennemi ennemi = new Ennemi("Ennemi", 50, 10);
        Objet objet = new Objet("Potion");
        Arme arme = new Arme("Épée", Arme.Rarete.COMMUN);

        // Testons la méthode ameliorerArme
        arme.ameliorerArme();
        arme.ameliorerArme();

        // Testons la méthode genererButin pour un ennemi tué
        ennemi.genererButin();

        // D'autres tests et interactions possibles ici
    }
}
