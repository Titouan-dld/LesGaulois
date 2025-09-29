package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
		
	}
	
	private void recevoirCoup(int forceCoup) {
		this.force = this.force - forceCoup;
		if(this.force <1){
			this.parler("J'abandonne")
			
		}
		else {
			this.parler("Aîe");
		}
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
	}
	
}
	
	

