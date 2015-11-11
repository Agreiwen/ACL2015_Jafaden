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
					System.out.println(laby.toString());
					if(!m.murAGauche()){
						m.deplacerPacmanGauche();
					}
					break;
				case "R":
					System.out.println(laby.toString());
					if(!m.murADroite()){
						m.deplacerPacmanDroite();
					}
					break;
				case "U":
					System.out.println(laby.toString());
					if(!m.murEnHaut()){
						m.deplacerPacmanHaut();
					}
					break;
				case "D":
					System.out.println(laby.toString());
					if(!m.murEnBas()){
						m.deplacerPacmanBas();
					}
					break;
				case "S":
					System.out.println(laby.toString());
					break;
				default:
					break;
			}
			//sc.close();
		}
	}

	public static void main(String[] args) {
		
		new MainClass();
	}
	
}
