package personnages;

public class Chaudron {

	private int quantitePotion;
	private int forcePotion;

	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}
	
	public boolean resterPotion() {
		if (this.quantitePotion == 0) return false;
		else return true;
	}
	
	public int prendreLouche() {
		if(this.resterPotion() == false) {
			this.forcePotion = 0;
		}
		this.quantitePotion = this.quantitePotion -1;
		return this.forcePotion;
	}
	
}
