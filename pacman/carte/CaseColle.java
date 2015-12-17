package pacman.carte;

import pacman.personnages.Hitbox;
import pacman.personnages.Personnage;

public class CaseColle extends CaseSpeciale{
	
	protected Hitbox hitbox;
	
		public CaseColle(int largeur, int hauteur) {
		super(largeur, hauteur);
		hitbox = new Hitbox(largeur*25, hauteur*25, 25, 25);
	}
	
	
	public boolean hit(Personnage p){
		return this.hitbox.intersects(p.getHitbox());
	}

}
