package personnages;

public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron;
	
	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte +"\"");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public String getNom() {
		return nom;
	}

	public void fabriquerPotion(int quantite, int forcePotion) {
		this.chaudron = new Chaudron();
		this.chaudron.remplirChaudron(quantite, forcePotion);
		parler("J'ai concocté " + quantite + " doses de potion magiques. Elle a une force de " + forcePotion + ".");
	}
	
	public void booster(Gaulois gaulois) {
		if (this.chaudron.resterPotion()) {
			if ("Obélix".equals(gaulois.getNom())) {
				parler("Non, " + gaulois.getNom() + " Non !... Et tu le sais très bien !");
			}
			else {
				int forcePotion = this.chaudron.prendreLouche();
				gaulois.boirePotion(forcePotion);
				parler("Tiens " + gaulois.getNom() + " un peu de potion Magique.");
			}
		}
		else {
			parler("Désolé " + gaulois.getNom() + "Il n'y a plus une seule goute de potion ");
		}
	}

	
	
}
