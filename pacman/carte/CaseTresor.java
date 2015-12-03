package pacman.carte;

public class CaseTresor extends CaseSpeciale{

	public CaseTresor(int largeur, int hauteur) {
		super(largeur, hauteur);
		this.ateignable=true;
	}

}
