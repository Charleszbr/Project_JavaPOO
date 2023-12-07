import model.*;

public class Main {
    public static void main(String[] args) {
        // Testons les classes de base ici
        Joueur joueur = new Joueur("Joueur", 100, 20);
        Ennemi ennemi = new Ennemi("Ennemi", 50, 10);
        Objet objet = new Objet("Potion");
        Arme arme = new Arme("Épée", Arme.Rarete.COMMUN);

        // Testons la méthode ameliorerArme
        arme.ameliorerArme();
        arme.ameliorerArme();

        // Testons la méthode genererButin pour un ennemi tué
        joueur.ramasserButin(ennemi);

        // Testons les nouvelles sous-classes et leurs méthodes
        Joueur nouveauJoueur = new Joueur("Nouveau Joueur", 150, 25);
        EnnemiGuerrier ennemiGuerrier = new EnnemiGuerrier("Guerrier", 60, 15, "Épée tranchante");
        EnnemiSorcier ennemiSorcier = new EnnemiSorcier("Sorcier", 40, 12, "Boule de feu");

        nouveauJoueur.ramasserButin(ennemiGuerrier);

        // Testons la compétence 'rage' de l'ennemiGuerrier
        ennemiGuerrier.utiliserCompetence(); // Active la compétence
        ennemiGuerrier.attaquerAvecRage(nouveauJoueur); // Attaque avec 'rage'

        // Testons l'interaction avec la potion
        Potion potion = new Potion("Potion de Soin", 20);

        potion.interact(joueur);

        // Utilisation de la surcharge de la méthode attaquer
        joueur.attaquer(nouveauJoueur, 10); // Attaque avec un bonus de 10 points de dégâts

        // D'autres tests et interactions possibles ici
    }
}
