package pacman.carte;

import static org.junit.Assert.*;

import org.junit.Test;

import pacman.personnages.Pacman;

public class LabyrintheTest {

	@Test
	public void testDeplacerPacmanGauche() {
		Labyrinthe l = new Labyrinthe(4,4, new Pacman(1, 1));
		l.deplacerPacmanGauche();
		assertEquals(0, l.getPacman().getLargeur());
	}
	
	@Test
	public void testDeplacerPacmanDroite() {
		Labyrinthe l = new Labyrinthe(4,4, new Pacman(1, 1));
		l.deplacerPacmanDroite();
		assertEquals(2, l.getPacman().getLargeur());
	}

	@Test
	public void testDeplacerPacmanHaut() {
		Labyrinthe l = new Labyrinthe(4,4, new Pacman(1, 1));
		l.deplacerPacmanHaut();
		assertEquals(2, l.getPacman().getHauteur());
	}

	@Test
	public void testDeplacerPacmanBas() {
		Labyrinthe l = new Labyrinthe(4,4, new Pacman(1, 1));
		l.deplacerPacmanBas();
		assertEquals(0, l.getPacman().getHauteur());
	}
}
