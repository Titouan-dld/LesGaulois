package personnages;

import java.util.Arrays;

import histoire.Musee;
import objets.Equipement;

public class Gaulois {
	private String nom;
	private int effetPotion;
	private Village village;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
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

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
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
	
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup(this.force*this.effetPotion / 3);
//		if(this.effetPotion >1) {
//			this.effetPotion = this.effetPotion-1;
//		}
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] newTrophees = romain.recevoirCoup((this.force / 3) * this.effetPotion);
		if(newTrophees != null) {
			for (int i = 0; i < newTrophees.length && nbTrophees < trophees.length; i++) {
	            trophees[nbTrophees++] = newTrophees[i];
	        }
		}
		
	}
	
	public void faireUneDonnation(Musee musee) {
		String texte = "Je donne au musee tous mes trophées ";
		for(int i = 0; i<nbTrophees; i++) {
			if(trophees[i] != null) {
			musee.donnerTrophees(this, trophees[i]);
			texte += "\n   -" + this.trophees[i];
			this.trophees[i] = null;
			}
		}
		nbTrophees = 0;
		this.parler(texte);
	}
	

}
