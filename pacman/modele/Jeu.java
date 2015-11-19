package pacman.modele;

import pacman.carte.Labyrinthe;
import pacman.personnages.Pacman;

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
	
	
	public boolean murADroite(){
		return (pacman.getLargeur()==laby.getLargeur()-1);
	}
	
	public boolean murAGauche(){
		return (pacman.getLargeur()==0);
	}
	
	public boolean murEnHaut(){
		return (pacman.getHauteur()==laby.getHauteur()-1);
	}
	
	public boolean murEnBas(){
		return (pacman.getHauteur()==0);
	}
	
	public int getCoordonneeHauteur(){
		return(pacman.getHauteur());
	}
	public int getCoordonneeLargeur(){
		return(pacman.getLargeur());
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
