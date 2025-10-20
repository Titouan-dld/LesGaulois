package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert this.isInvariantVerified();
	}
	
	private boolean isInvariantVerified() {
		return this.force>=0;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	public void recevoirCoup(int forceCoup) {
		assert forceCoup>=0;
		this.force = this.force - forceCoup;
		if(this.force <1){
			this.parler("J'abandonne !");
			this.force = 0;
		}
		else {
			this.parler("Aîe");
		}
		assert this.isInvariantVerified();
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
	}
}
	
	

