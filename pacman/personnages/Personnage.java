package pacman.personnages;

import pacman.carte.Labyrinthe;

public abstract class Personnage implements Sprite {

	protected int largeur;
	protected int hauteur;
        protected int ancienne_largeur;
        protected int ancienne_hauteur;
        protected Hitbox hitbox;
        
	
	
	public Personnage(int largeur, int hauteur){
		this.largeur=largeur;
		this.hauteur=hauteur;
                hitbox = new Hitbox(largeur, hauteur);
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
                savePosition();
		largeur-=1;
	}
	
	public void deplacerDroite(){
                savePosition();
		largeur+=1;
	}
	public void deplacerHaut(){
                savePosition();
		hauteur-=1;
	}
	public void deplacerBas(){
                savePosition();
		hauteur+=1;
	}
        
        private void savePosition(){
            ancienne_hauteur = hauteur;
            ancienne_largeur = largeur;
        }
        
        public void retourAnciennePosition(){
            largeur = ancienne_largeur;
            hauteur = ancienne_hauteur;
        }
        
        @Override
        public boolean collisionAvec(Hitbox h) {
            return this.hitbox.collisionAvec(h);
        }
        
        public Hitbox getHitbox(){
            return hitbox;
        }
}
