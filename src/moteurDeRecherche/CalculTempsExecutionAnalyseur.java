package moteurDeRecherche;

import java.util.List;

public class CalculTempsExecutionAnalyseur {
    private static final int ITERATIONS = 10; // Nombre d'itérations pour calculer la moyenne

    public static void main(String[] args) {
        Analyseur analyseurMap = new AnalyseurMap();
        Analyseur analyseurSet = new AnalyseurHashSet();
        Analyseur analyseurList = new AnalyseurListe();
        
        Extracteur extracteur = new MotParMotExtracteur();
        String path1 = "C:\\Users\\MSI\\OneDrive\\Desktop\\300.txt";

        System.out.println("800 mots");
        List<String> mots = extracteur.readDocument(path1);

        // Calculer le temps moyen d'exécution pour AnalyseurMap
        long totalMapTime = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            long startTime = System.nanoTime();
            analyseurMap.analyserDocument(mots);
            long endTime = System.nanoTime();
            totalMapTime += (endTime - startTime);
        }
        long averageMapTime = totalMapTime / ITERATIONS;
        System.out.println("Temps moyen d'exécution pour AnalyseurMap: " + averageMapTime + " nanosecondes");

        // Calculer le temps moyen d'exécution pour AnalyseurHashSet
        long totalSetTime = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            long startTime1 = System.nanoTime();
            analyseurSet.analyserDocument(mots);
            long endTime1 = System.nanoTime();
            totalSetTime += (endTime1 - startTime1);
        }
        long averageSetTime = totalSetTime / ITERATIONS;
        System.out.println("Temps moyen d'exécution pour AnalyseurHashSet: " + averageSetTime + " nanosecondes");

        // Calculer le temps moyen d'exécution pour AnalyseurListe
        long totalListTime = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            long startTime2 = System.nanoTime();
            analyseurList.analyserDocument(mots);
            long endTime2 = System.nanoTime();
            totalListTime += (endTime2 - startTime2);
        }
        long averageListTime = totalListTime / ITERATIONS;
        System.out.println("Temps moyen d'exécution pour AnalyseurListe: " + averageListTime + " nanosecondes");
    }
}
