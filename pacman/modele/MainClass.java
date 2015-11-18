package pacman.modele;

import java.util.Scanner;

import pacman.carte.Labyrinthe;
import pacman.personnages.Pacman;

public class MainClass {
	
	public MainClass(){
		Pacman pacman = new Pacman(0, 0);
		Labyrinthe laby = new Labyrinthe(5, 5);
		Jeu m = new Jeu(laby, pacman);
		boolean exit = false;
		while(!exit){
			System.out.println("Ecrire commande (L/R/U/D/S)");
			Scanner sc = new Scanner(System.in);
			String entree = sc.nextLine();
			switch(entree){
				case "L":
					if(!m.murAGauche()){
						m.deplacerPacmanGauche();
					}
					break;
				case "R":
					if(!m.murADroite()){
						m.deplacerPacmanDroite();
					}
					break;
				case "U":
					if(!m.murEnHaut()){
						m.deplacerPacmanHaut();
					}
					break;
				case "D":
					if(!m.murEnBas()){
						m.deplacerPacmanBas();
					}
					break;
				case "S":
					break;
				default:
					break;
			}
			System.out.println("Pacman en ("+m.getCoordonneeLargeur()+","+m.getCoordonneeHauteur()+")\n");
			System.out.println(m.toString());
		}
	}

	public static void main(String[] args) {
		new MainClass();
	}
	
}
