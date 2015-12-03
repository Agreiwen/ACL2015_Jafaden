package pacman.carte;
//
import pacman.personnages.Hitbox;
import pacman.personnages.Sprite;

public abstract class Case implements Sprite{
	
	
	/**
	 * Une Case est d�finie par une largeur et une hauteur, 
	 * correspondant � sa position dans le labyrinthe.
	 * On sait egalement si la case est ateignable par pacman gr�ce au param�tre ateignable.
	 */
	protected int largeur;
	protected int hauteur;
	protected boolean ateignable;
        protected Hitbox hitbox;

	
	public Case(int largeur, int hauteur){
		this.largeur=largeur;
		this.hauteur=hauteur;
                hitbox = new Hitbox(largeur, hauteur);
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
	
	public boolean isAteignable(){
		return this.ateignable;
	}

        public Hitbox getHitbox() {
            return hitbox;
        }
        
        @Override
        public boolean collisionAvec(Hitbox h) {
            return this.hitbox.collisionAvec(h);
        }
}
