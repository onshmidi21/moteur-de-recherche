package moteurDeRecherche;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyseurMap implements Analyseur {

	@Override
	public List<MotOccurrence> analyserDocument(List<String> list) {
        Map <String,Integer> comptage =  new HashMap<>();
        for (String m : list) {
            Integer n =comptage.get(m);
            if (n== null) {
            	comptage.put(m, 1);
            }
            else {
            	comptage.put(m, n+1);
            }
        }
		List<MotOccurrence> listeOccurrence =new ArrayList<MotOccurrence>();
		 for (Map.Entry<String, Integer> entry : comptage.entrySet()) {
	            String mot = entry.getKey();
	            Integer nbreOccurrence = entry.getValue();   
	            listeOccurrence.add(new MotOccurrence(mot,nbreOccurrence));
	            
	            }
		 return listeOccurrence ;
        }
	 @Override
		public String toString(){
	    	return "analyseur map";
	    }

}
