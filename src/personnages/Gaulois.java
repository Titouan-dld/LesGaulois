package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion;
	private Village village;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.effetPotion = 1;
		this.village = null;
	}

	public String getNom() {
		return nom;
	}
	
	public void setVillage(Village village) {
		this.village = village;
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte +"\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}
	
	public void sePresenter() {
		if(this.village == null) {
			System.out.println("Bonjour, je m'appelle " + this.getNom() + ". Je voyage de villages en villages.");
		}
		else if(this.village.getChef() == this) {
			System.out.println("Bonjour, je m'appelle " + this.getNom() + ". Je suis le chef du village " + this.village.getNom());;
		}
		else {
			System.out.println("Bonjour, je m'appelle " + this.getNom() + ". J'habite le village " + this.village.getNom());
		}
		}
	
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(this.force*this.effetPotion / 3);
		if(this.effetPotion >1) {
			this.effetPotion = this.effetPotion-1;
		}
	}


}
