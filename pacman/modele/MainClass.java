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
		System.out.println("Pacman en ("+m.getCoordonneeLargeur()+","+m.getCoordonneeHauteur()+")\n");
		while(!exit){
			System.out.println("Ecrire commande (L/R/U/D/S) \n");
			Scanner sc = new Scanner(System.in);
			String entree = sc.nextLine();
			System.out.println("Pacman en ("+m.getCoordonneeLargeur()+","+m.getCoordonneeHauteur()+")\n");

			switch(entree){
				case "L":
					
					if(!m.murAGauche()){
						m.deplacerPacmanGauche();
					}
					//System.out.println("Pacman en ("+m.getCoordonneeLargeur()+","+m.getCoordonneeHauteur()+")\n");

					//System.out.println(laby.toString());
					break;
				case "R":
					
					if(!m.murADroite()){
						m.deplacerPacmanDroite();
					}
					
					//System.out.println(laby.toString());
					break;
				case "U":
					
					if(!m.murEnHaut()){
						m.deplacerPacmanHaut();
					}
					//System.out.println(laby.toString());
					break;
				case "D":
					
					if(!m.murEnBas()){
						m.deplacerPacmanBas();
					}
					//System.out.println(laby.toString());
					break;
				case "S":
					//System.out.println(laby.toString());
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
