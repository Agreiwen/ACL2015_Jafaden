package pacman.modele;

import java.util.Scanner;

import pacman.carte.Labyrinthe;
import pacman.personnages.Pacman;

public class MainClass {
	
	public MainClass(){
		Pacman pacman = new Pacman(0, 0);
		Labyrinthe laby = new Labyrinthe(5, 5, pacman);
		Modele m = new Modele(laby);
		
		boolean exit = false;
		
		while(!exit){
			System.out.println("Ecrire commande (L/R/U/D/S) \n");
			Scanner sc = new Scanner(System.in);
			String entree = sc.nextLine();
			switch(entree){
				case "L":
					if(!m.murAGauche()){
						m.deplacerPacmanGauche();
						System.out.println("L");
					}
					break;
				case "R":
					if(!m.murADroite()){
						m.deplacerPacmanDroite();
						System.out.println("R");
					}
					break;
				case "U":
					if(!m.murEnHaut()){
						m.deplacerPacmanHaut();
						System.out.println("U");
					}
					break;
				case "D":
					if(!m.murEnBas()){
						m.deplacerPacmanBas();
						System.out.println("D");
					}
					break;
				case "S":
					System.out.println("S");
					break;
				default:
					break;
			}
			sc.close();
		}
	}

	public static void main(String[] args) {
		
		new MainClass();
	}
	
}
