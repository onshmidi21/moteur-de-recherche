package moteurDeRecherche;

import java.util.ArrayList;
import java.util.List;

public class IndexTest {
	 public static void main(String[] args) {
	        Index index = new IndexList();
	        Index index2 = new IndexDic();
	        Index index3= new IndexMap();


	        // Créez une liste de mots à indexer
	        List<MotOccurrence> mots = new ArrayList<>();
	        mots.add(new MotOccurrence("ons", 4));
	        mots.add(new MotOccurrence("ons", 2));
	        mots.add(new MotOccurrence("hmidi", 3));
	        mots.add(new MotOccurrence("info", 1));
	     // Créez une liste de mots à indexer
	        List<MotOccurrence> mots2 = new ArrayList<>();
	        mots2.add(new MotOccurrence("club", 4));
	        mots2.add(new MotOccurrence("Africain", 2));
	        mots2.add(new MotOccurrence("hmidi", 3));
	        mots2.add(new MotOccurrence("info2", 1));

	     // Appelez la méthode indexerListDeMot pour indexer la liste de mots
	        String path = "mon_fichier.txt";
	        index.ajouterListDeMot(mots, path);
	        index.afficherIndex();
	       
	        List<String> motsRecherches = new ArrayList<>();

	        motsRecherches.add("ons");
	        motsRecherches.add("oiseau");
	        List<Statistique> indextotale = index.getIndex();
	        System.out.println("Sous-index pour les mots 'ons' et 'oiseau':");
	        for (Statistique stat : indextotale) {
	            System.out.println(stat.toString());
	    }
	        List<Statistique> sousIndex = index.getStatistique(motsRecherches);
	        System.out.println("Sous-index pour les mots 'ons' et 'oiseau':");
	        for (Statistique stat : sousIndex) {
	            System.out.println(stat.toString());
	            
	    }
	 index2.ajouterListDeMot(mots, "fichier1.txt");
	 index2.ajouterListDeMot(mots2, "mon_fichier.txt");
     System.out.println("indexdic");

     index2.afficherIndex();
     index3.ajouterListDeMot(mots, "fichier1.txt");
	 index3.ajouterListDeMot(mots2, "mon_fichier.txt");
     System.out.println("indexMap");

     index3.afficherIndex();

     
     
     
     
	 }
}

