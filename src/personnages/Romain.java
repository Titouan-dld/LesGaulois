package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
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
	
//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup>=0;
//		this.force = this.force - forceCoup;
//		if(this.force <1){
//			this.parler("J'abandonne !");
//			this.force = 0;
//		}
//		else {
//			this.parler("Aîe");
//		}
//		assert this.isInvariantVerified();
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = CalculResistanceEquipement(forceCoup);
		if(forceCoup >=0) {
			this.force -= forceCoup;
		}
		if(force == 0) {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		else {
			parler("Aïe");
		}
		return equipementEjecte;
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
			break;
		case 1:
			if (this.equipements[0] == equipement) {
				System.out.println("Le soldat " + this.getNom() + " posséde déjà un " + equipement);
			}
			else {
				this.nbEquipement++;
				this.equipements[1] = equipement;
				System.out.println("Le soldat " + this.getNom() + " s’équipe avec un " + equipement);
			}
			break;
		default:
			System.out.println("Le soldat " + this.getNom() + " est déjà bien protégé");
			break;
		}
	}
	
	private int CalculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if ((nbEquipement != 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public int getForce() {
		return force;
	}

}
	
	

