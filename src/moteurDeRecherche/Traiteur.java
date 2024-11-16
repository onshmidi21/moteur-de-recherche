package moteurDeRecherche;

import java.util.List;

public interface Traiteur {
	List<String> traiterDocument(List<String> texteExtrait);
    String toString() ;

}
