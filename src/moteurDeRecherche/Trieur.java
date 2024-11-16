package moteurDeRecherche;

import java.util.List;

public interface Trieur {
	List<String> trierResulat(List<MotOccurrence>list );
	  String toString() ;
		 
}
