package pacman.modele;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pacman.carte.Labyrinthe;
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
		Modele m = new Modele(new Labyrinthe(4,4,new Pacman(3,0)));
		assertEquals(true, m.murADroite());
	}

	@Test
	public void testMurAGauche() {
		Modele m = new Modele(new Labyrinthe(4,4,new Pacman(0,0)));
		assertEquals(true, m.murAGauche());
	}

	@Test
	public void testMurEnHaut() {
		Modele m = new Modele(new Labyrinthe(4,4,new Pacman(0,3)));
		assertEquals(true, m.murEnHaut());
	}

	@Test
	public void testMurEnBas() {
		Modele m = new Modele(new Labyrinthe(4,4,new Pacman(0,0)));
		assertEquals(true, m.murEnBas());
	}

	@Test
	public void testDeplacerPacmanGauche() {
		Modele m = new Modele(new Labyrinthe(4,4,new Pacman(1,1)));
		m.deplacerPacmanGauche();
		assertEquals(0, m.getCoordonneeLargeur());
	}

	@Test
	public void testDeplacerPacmanDroite() {
		Modele m = new Modele(new Labyrinthe(4,4,new Pacman(1,1)));
		m.deplacerPacmanDroite();
		assertEquals(2, m.getCoordonneeLargeur());
	}

	@Test
	public void testDeplacerPacmanBas() {
		Modele m = new Modele(new Labyrinthe(4,4,new Pacman(1,1)));
		m.deplacerPacmanBas();
		assertEquals(0, m.getCoordonneeHauteur());
	}

	@Test
	public void testDeplacerPacmanHaut() {
		Modele m = new Modele(new Labyrinthe(4,4,new Pacman(1,1)));
		m.deplacerPacmanHaut();
		assertEquals(2, m.getCoordonneeHauteur());
	}

}
