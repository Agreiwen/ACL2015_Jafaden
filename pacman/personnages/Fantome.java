package pacman.personnages;

public class Fantome extends Personnage{

	public Fantome(int largeur, int hauteur) {
		super(largeur, hauteur);
	}

	public void deplacer(Pacman p){
		int haut = distanceManhatan(this.largeur, this.hauteur, p.largeur, p.hauteur);
	}
}
