package moteurDeRecherche;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Extracteur extracteur = new MotParMotExtracteur();
        Index index = new IndexDic();
        Analyseur analyseur = new AnalyseurMap();
        Traiteur traiteur1 = new TraiteurMotVide();
      //  Traiteur traiteur2 = new TraiteurCaractereSpecial();
       // Traiteur traiteur3 = new TraiteurEspace();
       Traiteur traiteur4 = new TraiteurMinuscule();
       // Traiteur traiteur5 = new TraiteurPonctuation();
        CalculateurDeScore calculateur = new CalculateurDeScore1();
        List<Traiteur> listeTraiteur = new ArrayList<>();
        listeTraiteur.add(traiteur1);
        //listeTraiteur.add(traiteur2);
      //  listeTraiteur.add(traiteur3);
        listeTraiteur.add(traiteur4);
        //listeTraiteur.add(traiteur5);
        Trieur trieur = new TriDec10max();
        MoteurDeRecherche moteurDeRecherche = new MoteurDeRecherche( extracteur,  listeTraiteur,  analyseur,  index,  calculateur,  trieur);

        boolean continuer = true;
        while (continuer) {
            System.out.println("Choisissez l'option :");
            System.out.println("1. Indexer");
            System.out.println("2. Rechercher");
            System.out.println("3. Configurer votre moteur de recherche");
            System.out.println("4. Afficher la configuration actuelle du moteur");
            System.out.println("5. Quitter");

            int choixMenuPrincipal = scanner.nextInt();
            scanner.nextLine(); // Consomme la ligne en surplus

            switch (choixMenuPrincipal) {
                case 1:
                    System.out.println("Veuillez saisir le chemin du fichier à indexer :");
                    String path = scanner.nextLine();
                    System.out.println("Chemin du fichier choisi : " + path);
                    moteurDeRecherche.index(path);
                    System.out.println("Indexation terminée.");
                    break;
                case 2:
                    System.out.println("Entrez votre requête de recherche :");
                    String requete = scanner.nextLine();
                    List<String> motsRequete = Arrays.asList(requete.split("\\s+"));
                    List<String> resultats = moteurDeRecherche.rechercher(motsRequete);
                    System.out.println("Résultats de la recherche :");
                    if (resultats.isEmpty()) {
                        System.out.println("Aucun résultat trouvé pour cette requête.");
                    } else {
                        for (String r: resultats) {
                            System.out.println("fichier : " + r);
                        }}
                    break;
                case 3:
                	 System.out.println("Configurer votre moteur de recherche :");
                	    System.out.println("Choisissez l'option à configurer :");
                	    System.out.println("1. Extracteur");
                	    System.out.println("2. Analyseur");
                	    System.out.println("3. Traiteur");
                	    System.out.println("4. Calculateur de score");
                	    System.out.println("5. Trieur");

                	    int choixConfig = scanner.nextInt();
                	    scanner.nextLine();  
                	    switch (choixConfig) {
                        case 1:
                         
                                    
                                    extracteur = new LigneParLigneExtracteur();
                                    System.out.println("Extracteur par lignes sélectionné.");
                                    moteurDeRecherche.setExtracteur(extracteur); 

                            
                            break;
                        case 2:
                            System.out.println("Choisissez un nouvel analyseur :");
                            System.out.println("1. Analyseur par liste");
                           
                            System.out.println("2. Analyseur par Set");
                            System.out.println("3. Analyseur par map");
                            // Ajoutez d'autres options si nécessaire
                            int choixAnalyseur = scanner.nextInt();
                            scanner.nextLine(); // Consomme la ligne en surplus

                            switch (choixAnalyseur) {
                                case 1:
                                    analyseur = new AnalyseurListe();
                                    System.out.println("Analyseur par liste sélectionné.");
                                    moteurDeRecherche.setAnalyseur(analyseur); 

                                    break;
                                
                                case 2:
                                    analyseur = new AnalyseurHashSet();
                                    System.out.println("Analyseur par hashSet sélectionné.");
                                    moteurDeRecherche.setAnalyseur(analyseur); 

                                    break;
                                case 3:
                                    analyseur = new AnalyseurMap();
                                    System.out.println("Analyseur par Map sélectionné.");
                                    moteurDeRecherche.setAnalyseur(analyseur); 

                                    break;
                                default:
                                    System.out.println("Option invalide. L'analyseur map par défaut reste sélectionné.");
                                    break;

                            }
                            break;

                            
                        case 3:
                            System.out.println("Configurer votre moteur de recherche :");
                            System.out.println("Voici les traiteurs disponibles :");
                            System.out.println("1. TraiteurMotVide");
                            System.out.println("2. TraiteurCaractereSpecial");
                            System.out.println("3. TraiteurEspace");
                            System.out.println("4. TraiteurMinuscule");
                            System.out.println("5. TraiteurPonctuation");
                            System.out.println("Combien de traiteurs souhaitez-vous ajouter ? (0 à 5)");

                            int choixNbTraiteurs = scanner.nextInt();
                            scanner.nextLine();

                            if (choixNbTraiteurs < 0 || choixNbTraiteurs > 5) {
                                System.out.println("Nombre de traiteurs invalide. Veuillez réessayer.");
                                break;
                            }

                            listeTraiteur.clear(); // Réinitialisez la liste des traiteurs à une liste vide

                            for (int i = 0; i < choixNbTraiteurs; i++) {
                                System.out.println("Entrez le numéro du traiteur à ajouter :");
                                int numTraiteur = scanner.nextInt();
                                scanner.nextLine();
                                if (numTraiteur >= 1 && numTraiteur <= 5) {
                                    Traiteur traiteurChoisi = null;
                                    switch (numTraiteur) {
                                        case 1:
                                            traiteurChoisi = new TraiteurMotVide();
                                            break;
                                        case 2:
                                            traiteurChoisi = new TraiteurCaractereSpecial();
                                            break;
                                        case 3:
                                            traiteurChoisi = new TraiteurEspace();
                                            break;
                                        case 4:
                                            traiteurChoisi = new TraiteurMinuscule();
                                            break;
                                        case 5:
                                            traiteurChoisi = new TraiteurPonctuation();
                                            break;
                                    }
                                    if (traiteurChoisi != null) {
                                        listeTraiteur.add(traiteurChoisi);
                                        System.out.println("Traiteur ajouté : " + traiteurChoisi.getClass().getSimpleName());
                                    }
                                } else {
                                    System.out.println("Numéro de traiteur invalide. Veuillez réessayer.");
                                    break;
                                }
                            }
                       

                            break;
                            
                        case 4:
                        
                            System.out.println("Choisissez un nouveau calculateur de score :");
                            System.out.println("1. CalculateurDeScore1");
                            System.out.println("2. CalculateurDeScore2");

                            int choixCalculateur = scanner.nextInt();
                            scanner.nextLine();

                            switch (choixCalculateur) {
                                case 1:
                                    calculateur = new CalculateurDeScore1();
                                    System.out.println("Calculateur de score 1 sélectionné.");
                                    moteurDeRecherche.setCalculateur(calculateur); 

                                    break;
                                case 2:
                                    calculateur = new CalculateurDeScore2();
                                    System.out.println("Calculateur de score 2 sélectionné.");
                                    moteurDeRecherche.setCalculateur(calculateur); 

                                    break;
                                    
                                default:
                                    System.out.println("Option invalide. Le calculateur de score1 par défaut reste sélectionné.");
                                    break;
                            }
                            break;

                        case 5:
                        	  System.out.println("Choisissez un nouveau trieur :");
                        	    System.out.println("1. Trieur de tout les resultats");
                        	    System.out.println("2. Trieur de 10 premiers resultats");

                        	    int choixTrieur = scanner.nextInt();
                        	    scanner.nextLine();

                        	    switch (choixTrieur) {
                        	        case 1:
                        	            trieur = new TrieurDecroissant();
                        	            System.out.println("Trieur decroissant sélectionné.");
                                        moteurDeRecherche.setTrieur(trieur); 

                        	            break;
                        	        case 2:
                        	            trieur = new TriDec10max();
                        	            System.out.println("Trieur de 10 premiers resultat  sélectionné.");
                        	           
                                        moteurDeRecherche.setTrieur(trieur); 
                                        break;
                        	        default:
                        	            System.out.println("Option invalide. Le trieur par défaut reste sélectionné.");
                        	            break;
                        	    }
                        	    break;
                        default:
                            System.out.println("Option invalide. Veuillez choisir une option valide.");
                    
                	    break;}
                	 break; 
                case 4:
                	System.out.println(moteurDeRecherche.toString());
                    break;

                case 5:
                    continuer = false;
                    break;
                default:
                    System.out.println("Option invalide. Veuillez choisir une option valide.");
            }
        }

        scanner.close();
    }
}
