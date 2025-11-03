package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	
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
	
	public void sEquiper(Equipement equipement) {
		switch(this.nbEquipement) {
		case 0:
			this.nbEquipement++;
			this.equipements[0] = equipement;
			System.out.println("Le soldat " + this.getNom() + " s’équipe avec un " + equipement);
		case 1:
			if (this.equipements[0] == equipement) {
				System.out.println("Le soldat " + this.getNom() + " posséde déjà un " + equipement);
			}
			else {
				this.nbEquipement++;
				this.equipements[1] = equipement;
				System.out.println("Le soldat " + this.getNom() + " s’équipe avec un " + equipement);
			}
		case 2:
			System.out.println("Le soldat " + this.getNom() + " est déjà bien protégé");
		}	
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		
	}
	
}
	
	

