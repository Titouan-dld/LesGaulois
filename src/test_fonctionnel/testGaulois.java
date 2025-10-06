package test_fonctionnel;

import personnages.Gaulois;
import personnages.Druide;
import personnages.Romain;

public class testGaulois {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Gaulois obelix = new Gaulois("Obelix", 8);
		Romain brutus = new Romain("Brustus", 14);
		Druide panoramix = new Druide("Panoramix", 2);
		
		panoramix.fabriquerPotion(4, 3);
		panoramix.booster(obelix);
		panoramix.booster(asterix);
		for(int i = 0; i<3; i++) {
			asterix.frapper(brutus);
		}

	}
	
}
