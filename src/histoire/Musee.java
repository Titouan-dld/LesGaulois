package histoire;

import objets.Equipement;
import personnages.Gaulois;

public class Musee {
	
	private Trophee[] trophees = new Trophee[200];
	int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement newEquipement) {
		Trophee newTrophee = new Trophee(gaulois, newEquipement);
		if(nbTrophee<=200) {
			this.trophees[nbTrophee] = newTrophee;
			this.nbTrophee ++;
		} else {
			System.out.println("Le musée est plein");
		}
	}
}
