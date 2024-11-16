package moteurDeRecherche;

import java.util.ArrayList;
import java.util.List;

public class TraiteurPonctuation implements Traiteur {

	@Override
	public List<String> traiterDocument(List<String> texteExtrait) {
        List<String> listeSansPonctuation = new ArrayList<>();

        for (String element : texteExtrait) {
            // Remplacer tous les caractères de ponctuation par des espaces
            String elementSansPonctuation = element.replaceAll("[\\p{Punct}]", " ");
            listeSansPonctuation.add(elementSansPonctuation);
        }
        
        return listeSansPonctuation;
	}
	@Override
	public String toString() {
	    	return "traiteur de  ponctuation";

     }
}
