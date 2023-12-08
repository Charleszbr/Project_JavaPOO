package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestionFichier {

    public static void sauvegarderJoueur(Joueur joueur, String cheminFichier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
            // Sauvegarde des informations du joueur dans le fichier
            writer.write("Nom: " + joueur.getNom());
            writer.newLine();
            writer.write("Points de Vie: " + joueur.getPointsDeVie());
            writer.newLine();
            writer.write("Force: " + joueur.getForce());
            writer.newLine();

            System.out.println("Sauvegarde réussie.");
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }

    public static Joueur chargerJoueur(String cheminFichier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            // Lecture des informations du joueur depuis le fichier
            String nom = reader.readLine().split(": ")[1];
            int pointsDeVie = Integer.parseInt(reader.readLine().split(": ")[1]);
            int force = Integer.parseInt(reader.readLine().split(": ")[1]);

            System.out.println("Chargement réussi.");
            return new Joueur(nom, pointsDeVie, force);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erreur lors du chargement : " + e.getMessage());
            return null;
        }
    }
}
