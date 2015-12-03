package pacman.tests.modele;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pacman.carte.Labyrinthe;
import pacman.modele.Jeu;
import pacman.personnages.Pacman;

public class JeuTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCaseLibre() {
		Pacman p = new Pacman(3, 0);
		Labyrinthe l = new Labyrinthe(4, 4);
		Jeu m = new Jeu(l,p,"src\test.txt");
		assertEquals(false, m.caseLibre(-1, 0));
		assertEquals(false, m.caseLibre(0, 4));
		assertEquals(true, m.caseLibre(2, 2));
		//assertEquals(true, m.murADroite());
	}

	@Test
	public void testDeplacerPacmanGauche() {
		Pacman p = new Pacman(1,0);
		Labyrinthe l = new Labyrinthe(4,4);
		Jeu m = new Jeu(l,p,"src\test.txt");
		m.deplacerGauche(p);
		assertEquals(0, p.getLargeur());
		m.deplacerGauche(p);
		assertEquals(0, p.getLargeur());
	}

	@Test
	public void testDeplacerPacmanDroite() {
		Pacman p = new Pacman(2,2);
		Labyrinthe l = new Labyrinthe(4,4);
		Jeu m = new Jeu(l,p,"src\test.txt");
		m.deplacerDroite(p);
		assertEquals(3, p.getLargeur());
		m.deplacerDroite(p);
		assertEquals(3, p.getLargeur());
	}

	@Test
	public void testDeplacerPacmanBas() {
		Pacman p = new Pacman(1,2);
		Labyrinthe l = new Labyrinthe(4,4);
		Jeu m = new Jeu(l,p,"src\test.txt");
		m.deplacerBas(p);
		assertEquals(3, p.getHauteur());
		m.deplacerBas(p);
		assertEquals(3, p.getHauteur());
	}

	@Test
	public void testDeplacerPacmanHaut() {
		Pacman p = new Pacman(1,1);
		Labyrinthe l = new Labyrinthe(4,4);
		Jeu m = new Jeu(l,p,"src\test.txt");
		m.deplacerHaut(p);
		assertEquals(0, p.getHauteur());
		m.deplacerHaut(p);
		assertEquals(0, p.getHauteur());
	}
	
	

}
