package pacman.personnages;

public class Pacman extends Personnage{

	
	public Pacman(int l, int h){
		super(l, h);
	}

	@Override
	public void misAJourHitbox() {
		hitbox.misAJour(this.getLargeurGraphique(), this.getHauteurGraphique());
	}
}
