package moteurDeRecherche;

import java.util.ArrayList;
import java.util.List;

public class TestPerformanceIndex {

    public static void main(String[] args) {
        // Initialisation des index
        Index indexDic = new IndexDic();
        Index indexList = new IndexList();
        Index indexMap = new IndexMap();

        Extracteur extracteur = new MotParMotExtracteur();
        String path1 = "C:\\Users\\MSI\\OneDrive\\Desktop\\300.txt";

        System.out.println("800 mots");
        List<String> mots = extracteur.readDocument(path1);
        Analyseur analyseur=new AnalyseurMap();
        List <MotOccurrence> mot = analyseur.analyserDocument(mots);

        // Mesure du temps d'exécution pour l'insertion de liste de mots
        long startTime, endTime;

        // IndexDic
        startTime = System.nanoTime();
        indexDic.ajouterListDeMot(mot, path1);
        endTime = System.nanoTime();
        System.out.println("Temps d'insertion (ajouterListDeMot) pour IndexDic: " + (endTime - startTime) + " nanosecondes");

        // IndexList
        startTime = System.nanoTime();
        indexList.ajouterListDeMot(mot, "document1");
        endTime = System.nanoTime();
        System.out.println("Temps d'insertion (ajouterListDeMot) pour IndexList: " + (endTime - startTime) + " nanosecondes");

        // IndexMap
        startTime = System.nanoTime();
        indexMap.ajouterListDeMot(mot, "document1");
        endTime = System.nanoTime();
        System.out.println("Temps d'insertion (ajouterListDeMot) pour IndexMap: " + (endTime - startTime) + " nanosecondes");

        // Création de la liste de mots à rechercher
        List<String> motsRecherche = new ArrayList<>();
        motsRecherche.add("leo");
       

        // Mesure du temps d'exécution pour la recherche

        // IndexDic
        startTime = System.nanoTime();
        indexDic.getStatistique(motsRecherche);
        endTime = System.nanoTime();
        System.out.println("Temps de recherche (getStatistique) pour IndexDic: " + (endTime - startTime) + " nanosecondes");

        // IndexList
        startTime = System.nanoTime();
        indexList.getStatistique(motsRecherche);
        endTime = System.nanoTime();
        System.out.println("Temps de recherche (getStatistique) pour IndexList: " + (endTime - startTime) + " nanosecondes");

        // IndexMap
        startTime = System.nanoTime();
        indexMap.getStatistique(motsRecherche);
        endTime = System.nanoTime();
        System.out.println("Temps de recherche (getStatistique) pour IndexMap: " + (endTime - startTime) + " nanosecondes");
    }
}

