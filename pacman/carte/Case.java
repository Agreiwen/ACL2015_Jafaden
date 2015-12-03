package pacman.carte;
//

public abstract class Case{
	
	
	/**
	 * Une Case est d�finie par une largeur et une hauteur, 
	 * correspondant � sa position dans le labyrinthe.
	 * On sait egalement si la case est ateignable par pacman gr�ce au param�tre ateignable.
	 */
	protected int largeur;
	protected int hauteur;
	protected boolean ateignable;

	
	public Case(int largeur, int hauteur){
		this.largeur=largeur;
		this.hauteur=hauteur;
	}


	public int getLargeur() {
		return largeur;
	}


	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}


	public int getHauteur() {
		return hauteur;
	}


	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	
	public boolean isAteignable(){
		return this.ateignable;
	}
}
