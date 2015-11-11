package pacman.modele;

import pacman.carte.Labyrinthe;

public class Modele {
	
	protected Labyrinthe laby;
	
	public Modele(Labyrinthe laby){
		this.laby=laby;
	}
	
	public boolean murADroite(){
		return (laby.getPacman().getCoordonneex()==laby.getLargeur()-1);
	}
	
	public boolean murAGauche(){
		return (laby.getPacman().getCoordonneex()==0);
	}
	
	public boolean murEnHaut(){
		return (laby.getPacman().getCoordonneey()==laby.getHauteur()-1);
	}
	
	public boolean murEnBas(){
		return (laby.getPacman().getCoordonneex()==0);
	}
	
	
	/**
	 * Methodes de deplacement du Pacman
	 */
	public void deplacerPacmanGauche(){
		laby.deplacerPacmanGauche();
	}
	public void deplacerPacmanDroite(){
		laby.deplacerPacmanDroite();
	}
	public void deplacerPacmanBas(){
		laby.deplacerPacmanBas();
	}
	public void deplacerPacmanHaut(){
		laby.deplacerPacmanHaut();
	}

}
