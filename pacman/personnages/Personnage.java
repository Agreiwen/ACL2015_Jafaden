package pacman.personnages;

import pacman.carte.Labyrinthe;

public abstract class Personnage {

	protected int largeur;
	protected int hauteur;
        
	
	
	public Personnage(int largeur, int hauteur){
		this.largeur=largeur;
		this.hauteur=hauteur;
	}


	public int getLargeur() {
		return largeur;
	}

	public int getLargeurGraphique() {
		return largeur*Labyrinthe.LARGEUR_CASE;
	}
	
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}


	public int getHauteur() {
		return hauteur;
	}

	public int getHauteurGraphique() {
		return hauteur*Labyrinthe.HAUTEUR_CASE;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	
	/* Methodes de deplacement */
	
	public void deplacerGauche(){
		largeur-=1;
	}
	
	public void deplacerDroite(){
		largeur+=1;
	}
	public void deplacerHaut(){
		hauteur-=1;
	}
	public void deplacerBas(){
		hauteur+=1;
	}
}
