package pacman.personnages;

public class Fantome extends Personnage{

	public Fantome(int largeur, int hauteur) {
		super(largeur, hauteur);
	}

	public void deplacer(Pacman p){
		int diffX = this.largeur - p.getLargeurGraphique();
		int diffY = this.hauteur - p.getHauteurGraphique();
		if(Math.abs(diffX)>Math.abs(diffY)){//largeur
			if(diffX<0){// p a droite
				this.deplacerDroite();
			}else{// p a gauche
				this.deplacerGauche();
			}
		}else {//hauteur
			if(diffY<0){// p en bas
				this.deplacerBas();
			}else{// p en haut
				this.deplacerHaut();
			}
		}
	}

	@Override
	public void misAJourHitbox() {
		// TODO Auto-generated method stub
		hitbox.misAJour(largeur, hauteur);
	}
}
