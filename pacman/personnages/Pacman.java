package pacman.personnages;

public class Pacman extends Personnage{

	protected int vie;
	public static int START_VIE = 3;
	
	public Pacman(int l, int h){
		super(l, h);
		vie = START_VIE;
	}
	
	public void perdreVie(){
		vie--;
	}
	
	public boolean mort(){
		return vie==0;
	}
	
	@Override
	public void misAJourHitbox() {
		hitbox.misAJour(this.getLargeurGraphique(), this.getHauteurGraphique());
	}

	public int getVie() {
		return vie;
	}
}
