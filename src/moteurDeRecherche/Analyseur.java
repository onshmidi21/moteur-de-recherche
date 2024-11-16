package moteurDeRecherche;

import java.util.List;

public interface Analyseur {
	List<MotOccurrence> analyserDocument(List<String>list );
    
    String toString() ;
}
