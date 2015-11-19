package pacman.tests.modele;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pacman.carte.Labyrinthe;
import pacman.modele.Jeu;
import pacman.personnages.Pacman;

public class ModeleTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMurADroite() {
		Pacman p = new Pacman(3, 0);
		Labyrinthe l = new Labyrinthe(4, 4);
		Jeu m = new Jeu(l,p);
		assertEquals(true, m.murADroite());
	}

	@Test
	public void testMurAGauche() {
		Pacman p = new Pacman(0,0);
		Labyrinthe l = new Labyrinthe(4,4);
		Jeu m = new Jeu(l,p);
		assertEquals(true, m.murAGauche());
	}

	@Test
	public void testMurEnHaut() {
		Pacman p = new Pacman(0,3);
		Labyrinthe l = new Labyrinthe(4,4);
		Jeu m = new Jeu(l,p);
		assertEquals(true, m.murEnHaut());
	}

	@Test
	public void testMurEnBas() {
		Pacman p = new Pacman(0,0);
		Labyrinthe l = new Labyrinthe(4,4);
		Jeu m = new Jeu(l,p);
		assertEquals(true, m.murEnBas());
	}

	@Test
	public void testDeplacerPacmanGauche() {
		Pacman p = new Pacman(0,0);
		Labyrinthe l = new Labyrinthe(4,4);
		Jeu m = new Jeu(l,p);
		m.deplacerPacmanGauche();
		assertEquals(0, m.getCoordonneeLargeur());
	}

	@Test
	public void testDeplacerPacmanDroite() {
		Pacman p = new Pacman(1,1);
		Labyrinthe l = new Labyrinthe(4,4);
		Jeu m = new Jeu(l,p);
		m.deplacerPacmanDroite();
		assertEquals(2, m.getCoordonneeLargeur());
	}

	@Test
	public void testDeplacerPacmanBas() {
		Pacman p = new Pacman(1,1);
		Labyrinthe l = new Labyrinthe(4,4);
		Jeu m = new Jeu(l,p);
		m.deplacerPacmanBas();
		assertEquals(0, m.getCoordonneeHauteur());
	}

	@Test
	public void testDeplacerPacmanHaut() {
		Pacman p = new Pacman(1,1);
		Labyrinthe l = new Labyrinthe(4,4);
		Jeu m = new Jeu(l,p);
		m.deplacerPacmanHaut();
		assertEquals(2, m.getCoordonneeHauteur());
	}

}
