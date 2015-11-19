package pacman.graphique.start;

import pacman.carte.Labyrinthe;
import pacman.graphique.engine.GameEngineGraphical;
import pacman.graphique.model.PacmanController;
import pacman.graphique.model.PacmanGame;
import pacman.graphique.model.PacmanPainter;
import pacman.modele.Jeu;
import pacman.personnages.Pacman;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) {
		Pacman pacman = new Pacman(0, 0);
		Labyrinthe laby = new Labyrinthe(Labyrinthe.NB_LIGNE, Labyrinthe.NB_COLONNE);
		Jeu m = new Jeu(laby, pacman);
		// creation du jeu particulier et de son afficheur
		PacmanGame game = new PacmanGame("helpFilePacman.txt");
		PacmanPainter painter = new PacmanPainter(pacman);
		PacmanController controller = new PacmanController();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(m, painter, controller);
		try {
			engine.run();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
