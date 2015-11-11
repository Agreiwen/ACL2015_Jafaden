package pacman.carte;

import pacman.personnages.Pacman;

public class Labyrinthe {

	protected int[][] grille;
	protected int largeur;
	protected int hauteur;
	
	protected Pacman pacman;
	
	/**
	 * 
	 * @param largeur la largeur du labyrinthe
	 * @param hauteur la hauteur du labyrinthe
	 */
	public Labyrinthe(int largeur, int hauteur, Pacman pacman){
		grille = new int[largeur][hauteur];
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.pacman = pacman;
	}


	public Pacman getPacman() {
		return pacman;
	}


	public void setPacman(Pacman pacman) {
		this.pacman = pacman;
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

	/**
	 * Methodes de deplacement du Pacman
	 */
	public void deplacerPacmanGauche() {
		pacman.deplacerGauche();
	}
	public void deplacerPacmanDroite() {
		pacman.deplacerDroite();
	}
	public void deplacerPacmanHaut() {
		pacman.deplacerHaut();
	}
	public void deplacerPacmanBas() {
		pacman.deplacerBas();
	}
	
	public String toString(){
		StringBuilder st = new StringBuilder();
		st.append("Labyrinthe : \n");
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				if(j==pacman.getLargeur() && i==pacman.getHauteur()){
					st.append("X");
				}else st.append("0");
			}
			st.append("\n");
		}
		st.append("\n");
		return st.toString();
	}
}
