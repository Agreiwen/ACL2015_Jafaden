package pacman.graphique.start;

import pacman.graphique.engine.GameEngineGraphical;
import pacman.graphique.model.PacmanController;
import pacman.graphique.model.PacmanGame;
import pacman.graphique.model.PacmanPainter;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		// creation du jeu particulier et de son afficheur
		PacmanGame game = new PacmanGame("helpFilePacman.txt");
		PacmanPainter painter = new PacmanPainter();
		PacmanController controller = new PacmanController();

		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
		engine.run();
	}

}
