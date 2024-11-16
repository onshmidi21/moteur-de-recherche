package moteurDeRecherche;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	public class IndexMap extends Index {
	    private Map<String, List<Statistique>> index;

	    public IndexMap() {
	        index = new HashMap<>();
	    }

	    @Override
	    public void ajouterUnMot(MotOccurrence motOccurrence, String path) {
	        String mot = motOccurrence.getMot();
	        int nbreOccurrence = motOccurrence.getNbreOccurrence();

	        // Vérifier si le mot existe déjà dans l'index
	        if (!index.containsKey(mot)) {
	            index.put(mot, new ArrayList<>());// keni moush mawjouda
	        }

	        // Ajouter la nouvelle statistique à la liste des statistiques pour ce mot
	        index.get(mot).add(new Statistique(mot, path, nbreOccurrence));//index.get(mot) : liste l fyhaa statistique
	    }

	    @Override
	    public List<Statistique> getIndex() {
	        // Créer une liste contenant toutes les statistiques de l'index
	        List<Statistique> indexResultant = new ArrayList<>();
	        for (List<Statistique> statistiques : index.values()) {
	            indexResultant.addAll(statistiques);
	        }
	        return indexResultant;
	    }

	    

	    @Override
	    public List<Statistique> getStatistique(List<String> mots) {
	        // Créer une liste pour stocker les statistiques des mots spécifiés
	        List<Statistique> result = new ArrayList<>();

	        // Parcourir chaque mot spécifié
	        for (String mot : mots) {
	            // Vérifier si le mot existe dans l'index
	            if (index.containsKey(mot)) {
	                // Ajouter toutes les statistiques correspondant à ce mot à la liste résultante
	                result.addAll(index.get(mot));
	            }
	        }

	        return result;
	    }

		@Override
		public void afficherIndex() {
			System.out.println("IndexMap :");
		    for (Map.Entry<String, List<Statistique>> entry : index.entrySet()) {
		        String mot = entry.getKey();
		        List<Statistique> statistiques = entry.getValue();
		        System.out.println("Mot : " + mot);
		        for (Statistique statistique : statistiques) {
		            System.out.println("    Fichier : " + statistique.getFichier() + ", Occurrences : " + statistique.getNombreOccurrence());
		        }
		    }			
		}
	}


