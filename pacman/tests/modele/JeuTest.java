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
		Pacman p = new Pacman(0, 0);
		Labyrinthe l = new Labyrinthe(20, 20);
		Jeu m = new Jeu(l,p,"src/labyFilePacman.txt");
		assertEquals(false, m.caseLibre(-1, 0));
		assertEquals(false, m.caseLibre(0, 4));
		assertEquals(true, m.caseLibre(2, 2));
		//assertEquals(true, m.murADroite());
	}

	@Test
	public void testDeplacerPacmanGauche() {
		Pacman p = new Pacman(1,0);
		Labyrinthe l = new Labyrinthe(20,20);
		Jeu m = new Jeu(l,p,"src/labyFilePacman.txt");
		m.deplacerGauche(p);
		assertEquals(0, p.getLargeur());
		m.deplacerGauche(p);
		assertEquals(0, p.getLargeur());
	}

	@Test
	public void testDeplacerPacmanDroite() {
		Pacman p = new Pacman(6,2);
		Labyrinthe l = new Labyrinthe(20,20);
		Jeu m = new Jeu(l,p,"src/labyFilePacman.txt");
		m.deplacerDroite(p);
		assertEquals(7, p.getLargeur());
		m.deplacerDroite(p);
		assertEquals(7, p.getLargeur());
	}

	@Test
	public void testDeplacerPacmanBas() {
		Pacman p = new Pacman(1,17);
		Labyrinthe l = new Labyrinthe(20,20);
		Jeu m = new Jeu(l,p,"src/labyFilePacman.txt");
		m.deplacerBas(p);
		assertEquals(18, p.getHauteur());
		m.deplacerBas(p);
		assertEquals(18, p.getHauteur());
	}

	@Test
	public void testDeplacerPacmanHaut() {
		Pacman p = new Pacman(1,1);
		Labyrinthe l = new Labyrinthe(20,20);
		Jeu m = new Jeu(l,p,"src/labyFilePacman.txt");
		m.deplacerHaut(p);
		assertEquals(0, p.getHauteur());
		m.deplacerHaut(p);
		assertEquals(0, p.getHauteur());
	}
	
	

}
