package pacman.carte;

import pacman.personnages.Hitbox;
import pacman.personnages.Personnage;

public class CaseTrappe extends CaseSpeciale{

	private CaseTrappe destination;
	protected Hitbox hitbox;
	protected char association;
	
	public CaseTrappe(int largeur, int hauteur, char c) {
		super(largeur, hauteur);
		this.ateignable=true;
		association = c;
		hitbox = new Hitbox(largeur*25, hauteur*25, 25, 25);
	}
	
	public void setDestination(CaseTrappe c){
		destination = c;
	}
	
	public CaseTrappe getDestination(){
		return destination;
	}

	public boolean isAssociation(CaseTrappe c){
		return c.association == this.association;
	}
	
	public boolean hit(Personnage p) {
		return this.hitbox.intersects(p.getHitbox());
	}
	
	public String toString(){
		return "association : "+association;
	}

}
