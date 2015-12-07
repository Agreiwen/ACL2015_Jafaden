package pacman.personnages;

import pacman.carte.Labyrinthe;

public abstract class Personnage {

	protected int largeur;
	protected int hauteur;
	protected Hitbox hitbox;
    public enum Direction{GAUCHE,DROITE,HAUT,BAS};
    private Direction direction = Direction.DROITE;

	public Personnage(int largeur, int hauteur){
		this.largeur=largeur;
		this.hauteur=hauteur;
		hitbox = new Hitbox(largeur, hauteur, 25, 25);
	}

	public Direction getDirection(){
		return direction;
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
		this.misAJourHitbox();
		this.direction = Direction.GAUCHE;
	}
	
	public void deplacerDroite(){
		largeur+=1;
		this.misAJourHitbox();
		this.direction = Direction.DROITE;
	}
	public void deplacerHaut(){
		hauteur-=1;
		this.misAJourHitbox();
		this.direction = Direction.HAUT;
	}
	public void deplacerBas(){
		hauteur+=1;
		this.misAJourHitbox();
		this.direction = Direction.BAS;
	}
	
	public Hitbox getHitbox() {
		return this.hitbox;
	}

	public boolean hit(Personnage p) {
		return this.hitbox.intersects(p.getHitbox());
	}
	
	public abstract void misAJourHitbox();
}
