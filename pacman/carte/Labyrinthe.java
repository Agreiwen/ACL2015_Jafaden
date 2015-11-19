package pacman.carte;

import pacman.personnages.Pacman;

public class Labyrinthe {

	protected int[][] grille;
	protected int largeur;
	protected int hauteur;
	
	//protected Pacman pacman;
	
	/**
	 * 
	 * @param largeur la largeur du labyrinthe
	 * @param hauteur la hauteur du labyrinthe
	 */
	public Labyrinthe(int largeur, int hauteur){
		grille = new int[largeur][hauteur];
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

	public boolean estLibre(int largeur, int hauteur){
		if (!(largeur < this.largeur) || !(hauteur < this.hauteur) || !(largeur > -1) || !(hauteur > -1)){
			return false;
		}else{
			return true;
		}
	}
	


	public int getHauteur() {
		return hauteur;
	}



}
