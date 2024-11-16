package moteurDeRecherche;

import java.util.ArrayList;
import java.util.List;

public class TraiteurTest {

public static void main(String[] args) {
    List<String> listeLignes = new ArrayList<>();
    listeLignes.add("Ceci ... to  £££  EST UNE premiere !ligne.");
    listeLignes.add("they Have ons is");
//tester le traiteur de l 'espace
    Traiteur traiteur = new TraiteurEspace(); 

    List<String> texteTraite = traiteur.traiterDocument(listeLignes);

    System.out.println("Texte traité :");
    for (String mot : texteTraite) {
        System.out.println(mot);
        
    }
    //tester le traiteur de minuscule
    Traiteur traiteur2 = new TraiteurMinuscule(); 
    List<String> texteTraite2 = traiteur2.traiterDocument(listeLignes);
    System.out.println("Texte traité2 :");

    for (String mot : texteTraite2) {
        System.out.println(mot);
        
    }
    //tester le traiteur de ponctuation 
    Traiteur traiteur3 = new TraiteurPonctuation(); 
    List<String> texteTraite3 = traiteur3.traiterDocument(listeLignes);
    System.out.println("Texte traité:");
    for (String mot : texteTraite3) {
        System.out.println(mot);
        
    }
  //tester le traiteur de caractere speciaux
    Traiteur traiteur4 = new TraiteurCaractereSpecial(); 
    List<String> texteTraite4 = traiteur4.traiterDocument(listeLignes);
    System.out.println("Texte traité:");
    for (String mot : texteTraite4) {
        System.out.println(mot);

      }
    //tester le traiteur de mot vide
    Traiteur traiteur5 = new TraiteurMotVide(); 
    List<String> texteTraite5 = traiteur5.traiterDocument(listeLignes);
    System.out.println("Texte traité5:");
    for (String mot : texteTraite5) {
        System.out.println(mot);

      }

}
}