package moteurDeRecherche;

import java.util.ArrayList;
import java.util.List;

public class TraiteurEspace implements Traiteur {

	@Override
	public List<String> traiterDocument (List<String> liste) {
		List<String> texteTraité=new ArrayList<String>();
		for (String ligne : liste) {
            // Diviser la ligne en mots
            String[] mots = ligne.split("\\s+");
            for (String mot : mots) {
                texteTraité.add(mot);}
	}
		return texteTraité;
	

	}
	@Override
	public String toString() {
	    	return "traiteur des espaces";

     }
}
