package pacman.carte;

public class CaseMur extends CaseNormale{

	
	/**
	 * La case est un mur donc ateignable est faux.
	 * @param largeur
	 * @param hauteur
	 */
	public CaseMur(int largeur, int hauteur) {
		super(largeur, hauteur);
		this.ateignable=false;
	}
	
	
	
	

}
