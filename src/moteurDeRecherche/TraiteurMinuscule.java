package moteurDeRecherche;

import java.util.ArrayList;
import java.util.List;

public class TraiteurMinuscule implements Traiteur {

		@Override
	    public List<String> traiterDocument(List<String> texteExtrait) {
	        List<String> listeMinuscule = new ArrayList<>();
	        
	        for (String element : texteExtrait) { //element est un mot ou ligne depend de extracteur
	            listeMinuscule.add(element.toLowerCase());
	        }
	        
	        return listeMinuscule;
	    }

		@Override
		public String toString() {
		    	return "traiteur de  minuscule";

	     }
		
	}

