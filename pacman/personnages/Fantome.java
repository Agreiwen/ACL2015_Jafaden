package pacman.personnages;

import pacman.carte.Labyrinthe;

public class Fantome extends Personnage{

	public Fantome(int largeur, int hauteur) {
		super(largeur, hauteur);
	}

	public void deplacer(Pacman p){
		int haut = distanceManhatan(this.largeur, this.hauteur-1, p.largeur*25, p.hauteur*25);
		int bas = distanceManhatan(this.largeur, this.hauteur+1, p.largeur*25, p.hauteur*25);
		int droite = distanceManhatan(this.largeur+1, this.hauteur, p.largeur*25, p.hauteur*25);
		int gauche = distanceManhatan(this.largeur-1, this.hauteur, p.largeur*25, p.hauteur*25);
		String min = getMin(haut, bas, droite, gauche);
		switch(min){
			case "haut":
				this.deplacerHaut();
				break;
			case "bas":
				this.deplacerBas();
				break;
			case "gauche":
				this.deplacerGauche();
				break;
			case "droite":
				this.deplacerDroite();
				break;
		
		}
	}

	private String getMin(int haut, int bas, int droite, int gauche) {
		String min = "haut";
		int tmp = haut;
		if(bas < tmp){
			min = "bas";
			tmp = bas;
		}
		if(droite < tmp){
			min = "droite";
			tmp = droite;
		}
		if(gauche < tmp){
			min = "gauche";
			tmp = gauche;
		}
		return min;
	}

	private int distanceManhatan(int largeur, int hauteur, int largeur2, int hauteur2) {
		return Math.abs(largeur-largeur2) + Math.abs(hauteur-hauteur2);
	}
}
