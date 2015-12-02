package pacman.carte;

public class Labyrinthe {

	public static final int NB_COLONNE = 20;
	public static final int NB_LIGNE = 20;
	protected int[][] grille;
	protected int largeur;
	protected int hauteur;
	public static int LARGEUR_CASE = 25;
	public static int HAUTEUR_CASE = 25;
	
	protected Case[][] tabCases;
	
	//protected Pacman pacman;
	
	/**
	 * 
	 * @param largeur la largeur du labyrinthe
	 * @param hauteur la hauteur du labyrinthe
	 */
	public Labyrinthe(int largeur, int hauteur){
		grille = new int[largeur][hauteur];
		tabCases = new Case[largeur][hauteur];
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public int[][] getGrille() {
		return grille;
	}


	public void setGrille(int[][] grille) {
		this.grille = grille;
	}


	public int getLargeur() {
		return largeur;
	}

	/**
	 * Teste si une position dans le labyrinthe est disponible, pour pouvoir s'y déplacer
	 * @param largeur
	 * @param hauteur 
	 * @return 
	 */
	public boolean estLibre(int largeur, int hauteur){
		boolean rep = true;
		
		/* Tests bords de map */
		if(largeur < 0)
			rep = false;
		else if((largeur >= (this.largeur))){
			rep = false;
		}else if((hauteur < 0)){
			rep = false;
		}else if((hauteur >= (this.hauteur))){
			rep = false;
		}
		
		/* Test Murs */
		if(rep){
			Case c = getCase(largeur, hauteur);
			rep = c.isAteignable();
		}
		return rep;
	}
	


	public int getHauteur() {
		return hauteur;
	}
	
	/**
	 * remplit le tableau de case, en instanciant différents types selon le 
	 *  tableau d'entiers, et donc selon le fichier de base. 
	 */
	public void remplirTabCases(){
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				Case c = null;
				switch(grille[i][j]){
				case 0:
					c = new CaseLibre(i,j);
					break;
				case 1:
					c = new CaseMur(i,j);
					break;
				default:
					c = new CaseLibre(i,j);
					break;
				}
				tabCases[i][j]=c;
			}
		}
	}
	
	/**
	 * 
	 * @param largeur
	 * @param hauteur
	 * @return une case du labyrinthe
	 */
	public Case getCase(int largeur, int hauteur){
		return tabCases[largeur][hauteur];
	}

	public int getLargeurTabCase(){
		return tabCases.length;
	}
	
	public int getHauteurTabCase(){
		return tabCases[0].length;
	}

}
