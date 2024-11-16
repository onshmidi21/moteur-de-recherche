package moteurDeRecherche;
import java.util.ArrayList;
import java.util.List;

public class IndexList extends Index {
    private List<Statistique> index;

    public IndexList() {
        index = new ArrayList<>();
    }


    @Override
    public void ajouterUnMot(MotOccurrence motOccurrence, String path) {
        
        	

            Statistique statistique = new Statistique(motOccurrence.getMot(), path,motOccurrence.getNbreOccurrence() );
            index.add(statistique);
        }
        
        
    
    
    

   

    @Override
    public List<Statistique> getIndex() {
        return index  ; 
    }
    private Statistique trouverStatistique(String mot) {
        for (Statistique statistique : index) {
            if (statistique.getMot().equals(mot)) {
                return statistique;
            }
        }
        return null;
        
    }
 
   
    
    @Override
    public List<Statistique> getStatistique(List<String> mots) {
    	List<Statistique> result = new  ArrayList<Statistique>();
        for (String mot : mots) {
            Statistique statistique = trouverStatistique(mot);
            if (statistique != null) {
                result.add(statistique);
        }
    }
		return result;
    }
    @Override
    public void afficherIndex() {
        for (Statistique statistique : index) {
        	System.out.println(statistique);;
        }}
   
}

