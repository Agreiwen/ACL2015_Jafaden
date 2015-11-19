package pacman.modele;

import pacman.carte.Labyrinthe;
import pacman.personnages.Pacman;
import pacman.personnages.Personnage;

public class Jeu {
	
	protected Labyrinthe laby;
	protected Pacman pacman;
	
	public Jeu(Labyrinthe laby, Pacman pacman){
		this.laby=laby;
		this.pacman=pacman;
	}
	
	public Pacman getPacman() {
		return pacman;
	}
	
	public void setPacman(Pacman pacman) {
		this.pacman = pacman;
	}
	
	public boolean caseLibre(int poslargeur, int poshauteur){
		return laby.estLibre(poslargeur, poshauteur);
	}
	
	
	public int getHauteurPersonnage(Personnage p){
		return(p.getHauteur());
	}
	public int getLargeurPersonnage(Personnage p){
		return(p.getLargeur());
	}
	
	/**
	 * Methodes de deplacement d'un personnage
	 */
	public void deplacerGauche(Personnage p) {
		p.deplacerGauche();
	}
	public void deplacerDroite(Personnage p) {
		p.deplacerDroite();
	}
	public void deplacerHaut(Personnage p) {
		p.deplacerHaut();
	}
	public void deplacerBas(Personnage p) {
		p.deplacerBas();
	}
	
	public String toString(){
		StringBuilder st = new StringBuilder();
		st.append("Labyrinthe : \n");
		for (int i = laby.getLargeur()-1; i >= 0; i--) {
			for (int j = 0; j < laby.getHauteur(); j++) {
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
