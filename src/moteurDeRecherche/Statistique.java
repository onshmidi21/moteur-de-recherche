package moteurDeRecherche;
public class Statistique {
    private String mot;
    private String fichier;
    private int nombreOccurrence;

    // Constructeur
    public Statistique(String mot, String fichier, int nombreOccurrence) {
        this.mot = mot;
        this.fichier = fichier;
        this.nombreOccurrence = nombreOccurrence;
    }

    // Getters et setters
    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    public int getNombreOccurrence() {
        return nombreOccurrence;
    }

    public void setNombreOccurrence(int nombreOccurrence) {
        this.nombreOccurrence = nombreOccurrence;
    }
    public String toString() {
        return "Mot: " + mot + ", Fichier: " + fichier + ", Occurrences: " + nombreOccurrence;
    }
}
