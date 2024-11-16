package moteurDeRecherche;

import java.util.ArrayList;
import java.util.List;

public class AnalyseurListe implements Analyseur {


	@Override
	public List<MotOccurrence> analyserDocument(List<String> list) {
		List<MotOccurrence> listeOccurrence =new ArrayList<MotOccurrence>();
        for (String mot : list) {
        	boolean motTrouve = false;

            // Parcourez la liste des occurrences pour vérifier si le mot existe déjà
            for (MotOccurrence occurrence : listeOccurrence) {
                if (occurrence.getMot().equals(mot)) {
                    // Si le mot existe déjà, mettez à jour son nombre d'occurrences
                    occurrence.setNbreOccurrence(occurrence.getNbreOccurrence() + 1);
                    motTrouve = true;
                    break;
                }
            }

            // Si le mot n'existe pas encore dans la liste, ajoutez-le avec une occurrence de 1
            if (!motTrouve) {
                listeOccurrence.add(new MotOccurrence(mot, 1));
            }
        }
 return listeOccurrence;
       
	}
	 @Override
		public String toString(){
	    	return "analyseur Liste";
	    }
}
