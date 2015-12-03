package pacman.tests.carte;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pacman.carte.Labyrinthe;

public class LabyrintheTest {

	@Test
	public void testEstLibre() {
		Labyrinthe l = new Labyrinthe(4,4);
		assertEquals(true ,l.estLibre(0, 0));
		assertEquals(false ,l.estLibre(-1, 0));
		assertEquals(false ,l.estLibre(4, 0));
		assertEquals(false ,l.estLibre(0, -1));
		assertEquals(false ,l.estLibre(0, 4));
	}
}
