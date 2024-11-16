package moteurDeRecherche;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CalculateurDeScore2 implements CalculateurDeScore {

	@Override
	public List<MotOccurrence> calculerScore(List<Statistique> statistiques) {
        Map<String, Integer> scores = new TreeMap<>();
	    List<MotOccurrence> listeFichierScore =new ArrayList<MotOccurrence>();

	    for (Statistique stat : statistiques) {
            String fichier = stat.getFichier();
            scores.put(fichier, scores.getOrDefault(fichier, 0) + 1);
        }
	   	            
	    for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            String fichier = entry.getKey();
            int nbOccurrences = entry.getValue();
            listeFichierScore.add(new MotOccurrence(fichier, nbOccurrences));
        }
	   		 

		
		return listeFichierScore;}
	 @Override
		public String toString() {
		    	return "calculateur de pertinence de fichier dans les stat";

	     }
}