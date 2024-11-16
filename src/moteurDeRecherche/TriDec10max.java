package moteurDeRecherche;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TriDec10max implements Trieur{

	@Override
	public List<String> trierResulat(List<MotOccurrence> list) {
		   // Trier les mots par ordre décroissant d'occurrence
		 Collections.sort(list, Comparator.comparing(MotOccurrence::getNbreOccurrence).reversed());

        // Créer une liste de mots triés
        List<String> motsTries = new ArrayList<>();
        int count = Math.min(10, list.size()); // Limiter à afficher les 10 premiers
        for (int i = 0; i < count; i++) {
            motsTries.add(list.get(i).getMot());
        }

        return motsTries;
	}
	 @Override
		public String toString() {
		    	return "trieur de 10 premiers resultats";

	     }
}
