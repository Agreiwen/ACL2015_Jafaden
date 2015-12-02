package pacman.carte;

public class CaseLibre extends CaseNormale{

	
	/**
	 * La case est libre donc ateignable est vrai.
	 * @param largeur
	 * @param hauteur
	 */
	public CaseLibre(int largeur, int hauteur) {
		super(largeur, hauteur);
		this.ateignable=true;
	}

}
