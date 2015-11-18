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


	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}


	public int getHauteur() {
		return hauteur;
	}


	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

}
