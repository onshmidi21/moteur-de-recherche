package moteurDeRecherche;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TrieurDecroissant implements Trieur {

  

	@Override
	 public List<String> trierResulat(List<MotOccurrence> list) {
		 Collections.sort(list, Comparator.comparing(MotOccurrence::getNbreOccurrence).reversed());
	        
	        // Créer une liste de mots triés
	        List<String> motsTries = new ArrayList<>();
	        for (MotOccurrence occurrence : list) {
	            motsTries.add(occurrence.getMot());
	        }

	        return motsTries;
    }
	 @Override
		public String toString() {
		    	return "trieur de tout les  resultats";

	     }
    
}
