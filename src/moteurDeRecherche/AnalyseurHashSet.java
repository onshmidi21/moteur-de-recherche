package moteurDeRecherche;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnalyseurHashSet implements Analyseur{
	
		@Override
		public List<MotOccurrence> analyserDocument(List<String> list) {
			   List<MotOccurrence> newListe = new ArrayList<>();
	        // Utiliser un HashSet pour stocker les mots déjà analysés et on ne trouve pas des doublons 
	        // Cela permettra de réduire le temps de recherche pour chaque mot
	        // si on utilise une liste et en le modifie directemet une execption se lance car en java en ne peut pas parcourir et supprimer en meme temps 
	        Set<String> motsAnalyses = new HashSet<>();

	        // parcourir la liste donne
	        for (String mot : list) {
	            // Vérifier si le mot a déjà été analysé pour éviter les doublons
	            if (!motsAnalyses.contains(mot)) {
	                int occur = nbreOccurence(list, mot);
	                newListe.add(new MotOccurrence(mot, occur));
	                // Ajouter le mot à l'ensemble des mots analysés
	                motsAnalyses.add(mot);
	            }
	        }
	        return newListe;}
	    
		
	    private int nbreOccurence(List<String> liste, String mot) {
	        int occurrences = 0;
	        for (String word : liste) {
	            if (word.equals(mot)) {
	                occurrences++;
	            }
	        }
	        return occurrences;
	    }
	    @Override
		public String toString(){
	    	return "analyseur hashSet";
	    }
	    }

