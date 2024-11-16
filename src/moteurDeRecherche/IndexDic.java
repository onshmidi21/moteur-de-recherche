package moteurDeRecherche;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexDic extends Index {
    private Map<String, Map<String, Integer>> index;

    public IndexDic() {
        index = new HashMap<>();
    }

    @Override
    public void ajouterUnMot(MotOccurrence motOccurrence, String path) {
        String mot = motOccurrence.getMot();
        int nbreOccurrence = motOccurrence.getNbreOccurrence();

        if (!index.containsKey(mot)) {
            index.put(mot, new HashMap<>());
        }
        Map<String, Integer> fichierOccurrences = index.get(mot);//retourne la valeur associée l mot
        fichierOccurrences.put(path, fichierOccurrences.getOrDefault(path, 0) + nbreOccurrence);
    }

    

    @Override
    public List<Statistique> getIndex() {
        List<Statistique> indexResultant = new ArrayList<>();
        for (Map.Entry<String, Map<String, Integer>> entry : index.entrySet()){//naamel f parcours al kol ligne ta index 
            String mot = entry.getKey();
            Map<String, Integer> fichierOccurrences = entry.getValue();
            for (Map.Entry<String, Integer> fichierOccurrence : fichierOccurrences.entrySet()) {
                String fichier = fichierOccurrence.getKey();
                int nbreOccurrence = fichierOccurrence.getValue();
                indexResultant.add(new Statistique(mot, fichier, nbreOccurrence));
            }
        }
        return indexResultant;
    }

          

		
	

	@Override
	public List<Statistique> getStatistique(List<String> mots) {
		 List<Statistique> result = new ArrayList<>();
	        for (String mot : mots) {
	            if (index.containsKey(mot)) {
	                Map<String, Integer> fichierOccurrences = index.get(mot);
	                for (Map.Entry<String, Integer> fichierOccurrence : fichierOccurrences.entrySet()) {
	                    String fichier = fichierOccurrence.getKey();
	                    int nbreOccurrence = fichierOccurrence.getValue();
	                    result.add(new Statistique(mot, fichier, nbreOccurrence));
	                }
	            }
	        }
	        return result;
	}
@Override
public void afficherIndex() {
    System.out.println("Index :");
    for (Map.Entry<String, Map<String, Integer>> entry : index.entrySet()) {
        String mot = entry.getKey();
        Map<String, Integer> fichierOccurrences = entry.getValue();
        System.out.println("Mot : " + mot);
        System.out.println("Occurrences par fichier :");
        for (Map.Entry<String, Integer> fichierOccurrence : fichierOccurrences.entrySet()) {
            String fichier = fichierOccurrence.getKey();
            int nbreOccurrence = fichierOccurrence.getValue();
            System.out.println("    Fichier : " + fichier + ", Occurrences : " + nbreOccurrence);
        }
    }
}}