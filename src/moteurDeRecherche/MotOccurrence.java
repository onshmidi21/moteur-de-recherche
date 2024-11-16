package moteurDeRecherche;

public class MotOccurrence {
private String mot ;
private int nbreOccurrence;
public String getMot() {
	return mot;
}
public int getNbreOccurrence() {
	return nbreOccurrence;
}
public void setNbreOccurrence(int nbreOccurrence) {
	this.nbreOccurrence = nbreOccurrence;
}
public MotOccurrence(String mot ,int nbreOccurrence){
	this.mot=mot;
	this.nbreOccurrence=nbreOccurrence;
	
	
}

public String toString () {
	return mot + " " + nbreOccurrence ;
	
	
}


}
