package moteurDeRecherche;


import java.util.ArrayList;
import java.util.List;
public class TraiteurMotVide implements Traiteur {

private static final List<String> MOTS_VIDES = new ArrayList<>(List.of(
        "i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your", "yours",
        "yourself", "yourselves", "he", "him", "his", "himself", "she", "her", "hers",
        "herself", "it", "its", "itself", "they", "them", "their", "theirs", "themselves",
        "what", "which", "who", "whom", "this", "that", "these", "those", "am", "is", "are",
        "was", "were", "be", "been", "being", "have", "has", "had", "having", "do", "does",
        "did", "doing", "a", "an", "the", "and", "but", "if", "or", "because", "as", "until",
        "while", "of", "at", "by", "for", "with", "about", "against", "between", "into",
        "through", "during", "before", "after", "above", "below", "to", "from", "up", "down",
        "in", "out", "on", "off", "over", "under", "again", "further", "then", "once", "here",
        "there", "when", "where", "why", "how", "all", "any", "both", "each", "few", "more",
        "most", "other", "some", "such", "no", "nor", "not", "only", "own", "same", "so",
        "than", "too", "very", "s", "t", "can", "will", "just", "don", "should", "now" ,"to"
));

@Override
public List<String> traiterDocument(List<String> texteExtrait) {
    List<String> texteTraité = new ArrayList<>();
    //lezemni nekseemha bsh tekhdem
    for (String ligne : texteExtrait) {
        String[] mots = ligne.split("\\s+");
        
    for (String mot : mots) {
        // Vérifiez si le mot n'est pas un mot vide 
        if (!MOTS_VIDES.contains(mot.toLowerCase())) {
        	texteTraité.add(mot);
        }
    }}
    return texteTraité;
}
@Override
public String toString() {
    	return "traiteur de  mot vide";

 }
}

