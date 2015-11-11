package pacman.personnages;

public class Pacman {

	
	private int largeur;
	private int hauteur;
	
	public Pacman(int largeur, int hauteur){
		this.largeur = largeur;
		this.hauteur = hauteur;
		
	}
	
	public void deplacerGauche(){
		largeur--;
	}
	
	public void deplacerDroite(){
		largeur++;
	}
	public void deplacerHaut(){
		hauteur++;
	}
	public void deplacerBas(){
		hauteur--;
	}
	
	public int getCoordonneex() {
		return largeur;
	}

	public void setCoordonneex(int coordonneex) {
		this.largeur = coordonneex;
	}

	public int getCoordonneey() {
		return hauteur;
	}

	public void setCoordonneey(int coordonneey) {
		this.hauteur = coordonneey;
	}

	
}
