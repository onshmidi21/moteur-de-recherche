package moteurDeRecherche;

import java.util.List;

public class ExtracteurTest {

    public static void main(String[] args) {
    	String filePath = "C:\\Users\\MSI\\Downloads\\tres_petit_corpus\\tres_petit_corpus\\186.txt" ;// Replace with the actual file path

        Extracteur extractor = new MotParMotExtracteur();
        
            List<String> words = extractor.readDocument(filePath);
            System.out.println("Extracted words:");
            for (String word : words) {
                System.out.println(word);
        
            }
         Extracteur extractor2 = new LigneParLigneExtracteur();
         List<String> lignes = extractor2.readDocument(filePath);
         for (String ligne : lignes) {
             System.out.println(ligne);
             }

    }
    
}