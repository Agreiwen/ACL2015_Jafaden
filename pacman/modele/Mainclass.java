package pacman.modele;

import pacman.carte.Labyrinthe;
import pacman.personnages.Pacman;

public class Mainclass {
	
	public Mainclass(){
		Pacman pacman = new Pacman(0, 0);
		Labyrinthe laby = new Labyrinthe(5, 5, pacman);
		Modele m = new Modele(laby);
		
		boolean exit = false;
		
		while(!exit){
			
		}
	}

	public static void main(String[] args) {
		new Mainclass();
	}
	
}
