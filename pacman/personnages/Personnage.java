package pacman.personnages;

public abstract class Personnage {

	protected static int largeur;
	protected static int hauteur;
	
	
	public Personnage(int largeur, int hauteur){
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
	
	
	/* Methodes de deplacement */
	
	public void deplacerGauche(){
		largeur--;
	}
	
	public void deplacerDroite(){
		largeur++;
	}
	public void deplacerHaut(){
		hauteur--;
	}
	public void deplacerBas(){
		hauteur++;
	}
	
}
