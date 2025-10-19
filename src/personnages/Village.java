package personnages;

public class Village {
	private String nom;
	private int nbVillageois;
	private Gaulois chef;
	private Gaulois[] villageois;
	

	public Village(String nom, Gaulois chef, int maxHabitant){
		this.nom = nom;
		this.nbVillageois = 0;
		this.chef = chef;
		this.villageois = new Gaulois[maxHabitant];
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		this.nbVillageois ++;
		this.villageois[this.nbVillageois -1] = gaulois;
	}
	
	public Gaulois trouverVillageois(int numVillageois){
		if (numVillageois < 0 || numVillageois > this.nbVillageois) {
			System.out.println("Il n'y a pas autant de gaulois !");
			return null;
		}
		else 
			return this.villageois[numVillageois-1];
	}
	
	public void afficherVillage() {
		System.out.println("Dans le village " + this.getNom() + "du chef " + this.chef.getNom() + " vivent les légendaires gaulois :");
		for(int i = 0; i<this.nbVillageois; i++) {
			System.out.println(this.villageois[i].getNom());
		}
		
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductible", abraracourcix, 30);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterVillageois(asterix);
		village.afficherVillage();
	}
	
}
