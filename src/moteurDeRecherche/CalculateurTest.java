package moteurDeRecherche;

import java.util.ArrayList;
import java.util.List;

public class CalculateurTest {

public static void main(String[] args) {
    // Créer une liste de statistiques
    List<Statistique> statistiques = new ArrayList<>();
    statistiques.add(new Statistique("mot1", "fichier1.txt", 3));
    statistiques.add(new Statistique("mot2", "fichier2.txt", 2));
    statistiques.add(new Statistique("mot3", "fichier1.txt", 1));
    statistiques.add(new Statistique("mot1", "fichier2.txt", 4));
    statistiques.add(new Statistique("mot3", "fichier1.txt", 1));
    statistiques.add(new Statistique("mot3", "fichier2.txt", 1));
    statistiques.add(new Statistique("mot3", "fichier2.txt", 1));

    // Créer un calculateur de score1
    CalculateurDeScore calculateur = new CalculateurDeScore2();

    // Calculer les scores
    List<MotOccurrence> scores = calculateur.calculerScore(statistiques);

    // Afficher les scores calculés
    for (MotOccurrence score : scores) {
        System.out.println(score.getMot() + " : " + score.getNbreOccurrence());
    }
}
}
