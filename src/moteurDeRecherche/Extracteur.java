package moteurDeRecherche;
import java.util.List;

public interface Extracteur {
	
	List<String> readDocument(String path);
    String toString() ;


}