package pacman.tests.personnages;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pacman.personnages.Pacman;

public class PersonnageTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeplacerGauche() {
		Pacman p = new Pacman(1,0);
		p.deplacerGauche();
		assertEquals(0, p.getLargeur());
	}
	
	@Test
	public void testDeplacerDroite() {
		Pacman p = new Pacman(1,0);
		p.deplacerDroite();
		assertEquals(2, p.getLargeur());
	}

	@Test
	public void testDeplacerHaut() {
		Pacman p = new Pacman(1,1);
		p.deplacerHaut();
		assertEquals(0, p.getHauteur());
	}

	@Test
	public void testDeplacerBas() {
		Pacman p = new Pacman(1,1);
		p.deplacerBas();
		assertEquals(2, p.getHauteur());
	}


}
