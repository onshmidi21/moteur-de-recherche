package moteurDeRecherche;

import java.util.ArrayList;
import java.util.List;

public class TraiteurCaractereSpecial implements Traiteur {

	@Override
	public List<String> traiterDocument(List<String> texteExtrait) {
     List<String> listeSansCaracteresSpeciaux = new ArrayList<>();
        
        for (String element : texteExtrait) {
            // Remplacer tous les caractères spéciaux par des espaces
            String elementSansCaracteresSpeciaux = element.replaceAll("[^a-zA-Z0-9 ]", " ");
            listeSansCaracteresSpeciaux.add(elementSansCaracteresSpeciaux);
        }
        
        return listeSansCaracteresSpeciaux;		
	}
	@Override
	public String toString() {
	    	return "traiteur de  caractere special";

     }

}
