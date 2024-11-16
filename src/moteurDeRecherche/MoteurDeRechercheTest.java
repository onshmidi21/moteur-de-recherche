package moteurDeRecherche;

import java.util.ArrayList;
import java.util.List;

public class MoteurDeRechercheTest {

    public static void main(String[] args) {
  
        Extracteur extracteur = new MotParMotExtracteur ();
        Traiteur traiteur1 = new TraiteurMotVide(); 
        Traiteur traiteur2 = new TraiteurCaractereSpecial(); 
        Traiteur traiteur3 = new TraiteurEspace(); 
        Traiteur traiteur4 = new TraiteurMinuscule(); 
        Traiteur traiteur5 = new TraiteurPonctuation(); 

        Analyseur analyseur = new AnalyseurListe(); 
        IndexDic index2 = new IndexDic();
        List<Traiteur>listeTraiteur=new ArrayList<>();
        listeTraiteur.add(traiteur1);
        listeTraiteur.add(traiteur2);
        listeTraiteur.add(traiteur3);
        listeTraiteur.add(traiteur4);
        listeTraiteur.add(traiteur5);

        CalculateurDeScore c =  new CalculateurDeScore1 ();
        Trieur t = new TrieurDecroissant ();
        MoteurDeRecherche m =new MoteurDeRecherche(extracteur,listeTraiteur,analyseur,index2,c,t);
       /* String path = "C:\\Users\\MSI\\Downloads\\tres_petit_corpus\\tres_petit_corpus\\186.txt";
        String path2 = "C:\\Users\\MSI\\Downloads\\tres_petit_corpus\\tres_petit_corpus\\185.txt";
        String path3 = "C:\\Users\\MSI\\Downloads\\tres_petit_corpus\\tres_petit_corpus\\184.txt";
        String path4 = "C:\\Users\\MSI\\Downloads\\tres_petit_corpus\\tres_petit_corpus\\188.txt";*/
        String pathDossier = "C:\\Users\\MSI\\Downloads\\grand_corpus\\corpus";

        //MoteurDeRecherche m2 =new MoteurDeRecherche(extracteur,listeTraiteur,analyseur,index2,c,t);
       //m.indexDirectory(pathDossier);
        //m.indexSingleDocument( path);
       // m.indexSingleDocument( path2);
        //m.indexSingleDocument( path3);
        //System.out.println("index");
        //m2.indexSingleDocument( path);
        //m2.indexSingleDocument( path2);
        //m2.indexSingleDocument( path3);
        //m2.indexSingleDocument( path4);
        //m.indexDirectory( pathDossier);

         System.out.println("index2");

        //Map<String, Integer> scores = c.calculerScore(indexList);
         List<String> requete2=new ArrayList <String>();

        List<String> requete=new ArrayList <String>();
        requete.addAll(List.of("Holocaust", "Malta","is","easier"));
        requete2.addAll(List.of("himself","is"));
        //List<Statistique>s=index2.getIndex(requete);
        //for(Statistique m1 :s) {
           // System.out.println(m1.toString());

        //}
        //index2.afficherIndex();

        List<String> scores=m.rechercher(requete);
        System.out.println("SCORES");
        for (String r: scores) {
            System.out.println("Fichier : " + r);}

        //afficherScores(scores);
       // List<String>Resultat=m.rechercher(requete);
        //for (String r: Resultat) {
           // System.out.println("Fichier : " + r);

        	
       // }
        //System.out.println("tester les mots vides");

        //List<String>Resultat2=m2.rechercher(requete2);
        //for (String r: Resultat2) {
           // System.out.println("Fichier : " + r);

        	
       // }
        
        

    }
    public static void afficherScores(List<MotOccurrence> scores) {
    	 for (MotOccurrence occurrence : scores) {
    	        String fichier = occurrence.getMot();
    	        int score = occurrence.getNbreOccurrence();
    	        System.out.println("Fichier: " + fichier + ", Score: " + score);
    	    }
    }
}

