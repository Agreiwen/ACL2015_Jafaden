package pacman.tests.carte;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pacman.carte.Labyrinthe;
import pacman.graphique.model.PacmanGame;
import pacman.modele.Jeu;
import pacman.personnages.Pacman;

public class LabyrintheTest {

	@Test
	public void testEstLibre() {
		Labyrinthe l = new Labyrinthe(Labyrinthe.NB_LIGNE, Labyrinthe.NB_COLONNE);
		// creation du jeu particulier et de son afficheur
		PacmanGame game = new PacmanGame("src/helpFilePacman.txt");
		Pacman pacman = new Pacman(0, 0);
		Jeu m = new Jeu(l, pacman,"src/labyFilePacman.txt");
		assertEquals(true ,l.estLibre(1, 0));
		assertEquals(false ,l.estLibre(-1, 0));
		assertEquals(false ,l.estLibre(25, 0));
		assertEquals(false ,l.estLibre(0, -1));
		assertEquals(false ,l.estLibre(0, 25));
	}
}
