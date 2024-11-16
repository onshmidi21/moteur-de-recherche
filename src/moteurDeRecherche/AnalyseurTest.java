package moteurDeRecherche;

import java.util.ArrayList;
import java.util.List;

public class AnalyseurTest {
	public static void main(String[] args) {
        Analyseur analyseurMap = new AnalyseurMap();
       Analyseur analyseurSet = new AnalyseurHashSet();
       // Analyseur analyseurList = new AnalyseurListe();
        List<String> mots = new ArrayList<>();
        mots.add("mot1");
        mots.add("mot3");
        mots.add("mot1");
        mots.add("mot1");
        mots.add("mot2");
        mots.add("mot1");
        mots.add("mot3");
        mots.add("mot2");

        List<MotOccurrence> occurrences2 = analyseurSet.analyserDocument(mots);

        for (MotOccurrence occurrence : occurrences2) {
            System.out.println(occurrence);
        }
        
    }

}
