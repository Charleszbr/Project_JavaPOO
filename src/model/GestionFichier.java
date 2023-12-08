package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestionFichier {

    /**
     * Méthode pour sauvegarder les informations du joueur dans un fichier.
     *
     * @param joueur          Le joueur à sauvegarder.
     * @param cheminFichier   Le chemin du fichier de sauvegarde.
     */
    public static void sauvegarderJoueur(Joueur joueur, String cheminFichier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {

            // Sauvegarde du nombre de pièces du joueur
            writer.write("Nombre de Pièces: " + joueur.getNombrePieces());
            writer.newLine();

            // Sauvegarde des potions dans l'inventaire
            for (ObjetDuJeu objet : joueur.getInventaire()) {
                if (objet instanceof Potion) {
                    Potion potion = (Potion) objet;
                    writer.write("Potion: " + potion.getNom() + "," + potion.getSoin());
                    writer.newLine();
                }
            }

            System.out.println("Sauvegarde réussie.");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }

    /**
     * Méthode pour charger les informations d'un joueur depuis un fichier.
     *
     * @param cheminFichier Le chemin du fichier de sauvegarde à charger.
     * @return Le joueur chargé.
     */
    public static Joueur chargerJoueur(String cheminFichier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            // Lecture des informations du joueur depuis le fichier
            int nombrePieces = Integer.parseInt(reader.readLine().split(": ")[1]);

            // Création d'un nouveau joueur avec le nombre de pièces chargé
            Joueur joueur = new Joueur("", 0, 0);
            joueur.ajouterPieces(nombrePieces);

            // Lecture des potions dans l'inventaire
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                if (ligne.startsWith("Potion: ")) {
                    String[] elements = ligne.split(", ");
                    Potion potion = new Potion(elements[1], Integer.parseInt(elements[2]));
                    joueur.ajouterObjet(potion);
                }
            }

            System.out.println("Chargement réussi.");
            return joueur;
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erreur lors du chargement : " + e.getMessage());
            return null;
        }
    }
}
