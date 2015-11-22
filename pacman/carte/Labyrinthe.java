package pacman.carte;

import pacman.personnages.Pacman;

public class Labyrinthe {

	public static final int NB_COLONNE = 20;
	public static final int NB_LIGNE = 20;
	protected int[][] grille;
	protected int largeur;
	protected int hauteur;
	public static int LARGEUR_CASE = 25;
	public static int HAUTEUR_CASE = 25;
	
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
		boolean rep = true;
		if(largeur < 0)
			rep = false;
		else if((largeur >= (NB_COLONNE))){
			rep = false;
		}else if((hauteur < 0)){
			rep = false;
		}else if((hauteur >= (NB_LIGNE))){
			rep = false;
		}
		return rep;
	}
	


	public int getHauteur() {
		return hauteur;
	}



}
