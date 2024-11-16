package moteurDeRecherche;

import java.util.List;

public interface CalculateurDeScore {
	List<MotOccurrence>calculerScore(List<Statistique>statistiques); 
	String toString();
}
