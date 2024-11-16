package moteurDeRecherche;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateurDeScore1 implements CalculateurDeScore{

	

	@Override
	public List <MotOccurrence>calculerScore(List<Statistique>statistiques) {
		Map<String, Integer> scores = new HashMap<>();
		 for (Statistique s : statistiques) {
	            Integer n =scores.get(s.getFichier());
	            if (n== null) {
	            	scores.put(s.getFichier(), s.getNombreOccurrence());
	            }
	            else {
	            	scores.put(s.getFichier(), n+s.getNombreOccurrence());
	            }
	        }

       List<MotOccurrence> listeFichierScore =new ArrayList<MotOccurrence>();
		 for (Map.Entry<String, Integer> entry : scores.entrySet()) {
	            String mot = entry.getKey();
	            Integer nbreOccurrence = entry.getValue();   
	            listeFichierScore.add(new MotOccurrence(mot,nbreOccurrence));
	            
	            }
		 return listeFichierScore ;	}
	 @Override
		public String toString() {
		    	return "Calculateur de somme de nbre d'occurence";

	     }
}
