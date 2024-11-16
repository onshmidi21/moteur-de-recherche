package moteurDeRecherche;

import java.util.List;

public abstract class Index {


	
	public  abstract void ajouterUnMot(MotOccurrence mot,String path) ;	 
	
	public void ajouterListDeMot(List<MotOccurrence> list, String path) {
		   for (MotOccurrence motOccurrence : list) {
	            ajouterUnMot(motOccurrence, path);
	        }
	    }
	public abstract List<Statistique> getIndex();
    public abstract List<Statistique> getStatistique(List<String> mots) ;
	public abstract void afficherIndex();
    

    
    	
    }

