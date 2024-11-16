package moteurDeRecherche;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class MoteurDeRecherche {
private Extracteur extracteur ;
private List<Traiteur> listeTraiteur;
private Analyseur analyseur;
private Index index ;
private CalculateurDeScore calculateur;
private Trieur trieur;
public Extracteur getExtracteur() {
	return extracteur;
}
public void setExtracteur(Extracteur extracteur) {
	this.extracteur = extracteur;
}
public Analyseur getAnalyseur() {
	return analyseur;
}
public void setAnalyseur(Analyseur analyseur) {
	this.analyseur = analyseur;
}
public Index getIndex() {
	return index;
}
public void setIndex(Index index) {
	this.index = index;
}
public CalculateurDeScore getCalculateur() {
	return calculateur;
}
public void setCalculateur(CalculateurDeScore calculateur) {
	this.calculateur = calculateur;
}
public Trieur getTrieur() {
	return trieur;
}
public void setTrieur(Trieur trieur) {
	this.trieur = trieur;
}



public MoteurDeRecherche(Extracteur extracteur, CalculateurDeScore calculateur, Index index, List<Traiteur> listeTraiteur, Analyseur analyseur) {
    this.extracteur = extracteur;
    this.listeTraiteur = listeTraiteur;
    
    this.index = index;
    this.analyseur = analyseur;
    this.calculateur = calculateur;
}

public MoteurDeRecherche(Extracteur extracteur, List<Traiteur> listeTraiteur, Analyseur analyseur, Index index, CalculateurDeScore calculateur, Trieur trieur) {
    this.extracteur = extracteur;
    this.analyseur = analyseur;
    this.index = index;
    this.calculateur = calculateur;
    this.trieur = trieur;
    this.listeTraiteur = listeTraiteur;
}


public void index(String path){
    File filePath = Paths.get(path).toFile();
    if(filePath.exists()){
        if(filePath.isDirectory()){
            System.out.println(path+" is a directory");
            indexDirectory(path);
        }else{
            System.out.println(path+" is a file");
            indexSingleDocument(path);
        }
    }else{
        System.out.println(path+" does not exist");
    }
    
}



private void indexSingleDocument(String path){
	List<String> texteExtraite = new ArrayList<String> ();
    texteExtraite=extracteur.readDocument(path);
	 for (Traiteur traiteur : listeTraiteur) {
		 texteExtraite = traiteur.traiterDocument(texteExtraite);
	    }
	 List<MotOccurrence> texteAnalysé = new ArrayList<MotOccurrence> ();
	texteAnalysé=analyseur.analyserDocument(texteExtraite);
	index.ajouterListDeMot(texteAnalysé,path);
	
	


    
}

private void indexDirectory(String path){
    File pathFile = Paths.get(path).toFile();
    File[] files = pathFile.listFiles();
    for(File f: files ){
        if(f.isDirectory()){
            indexDirectory(f.getAbsolutePath());
        }else{
            indexSingleDocument(f.getAbsolutePath());
        }
    }}

public List<String> rechercher (List<String>  requete){
    List<String> requeteTraité = new ArrayList<>(requete);

	for (Traiteur traiteur : listeTraiteur) {
		 requeteTraité = traiteur.traiterDocument(requeteTraité);
    }
	List<Statistique> statistique =index.getStatistique(requeteTraité);
	List<MotOccurrence> resultat = calculateur.calculerScore(statistique);
	List<String> resultatFinal=trieur.trierResulat(resultat);
	return resultatFinal ;
}
public List<MotOccurrence>  rechercherSansTri (List<String>  requete){
	List<String> requeteTraité = new ArrayList<>(requete);

	for (Traiteur traiteur : listeTraiteur) {
		 requeteTraité = traiteur.traiterDocument(requeteTraité);
    }
	List<Statistique> s =index.getStatistique(requeteTraité);
	List<MotOccurrence> resultat = calculateur.calculerScore(s);
	return resultat ;
}
public List<Traiteur> getListeTraiteur() {
	return listeTraiteur;
}
public void setListeTraiteur(List<Traiteur> listeTraiteur) {
	this.listeTraiteur = listeTraiteur;
}


public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Configuration actuelle du moteur de recherche :\n");
    builder.append("Extracteur : ").append(extracteur.toString()).append("\n");
    builder.append("Analyseur : ").append(analyseur.toString()).append("\n");
    builder.append("Traiteurs :\n");
    for (Traiteur traiteur : listeTraiteur) {
        builder.append("- ").append(traiteur.toString()).append("\n");
    }
    builder.append("Calculateur de score : ").append(calculateur.toString()).append("\n");
    builder.append("Trieur : ").append(trieur.toString()).append("\n");
    return builder.toString();
}}




