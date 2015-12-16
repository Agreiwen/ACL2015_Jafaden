package pacman.tests.carte;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pacman.carte.CaseTrappe;
import pacman.carte.Labyrinthe;
import pacman.personnages.Pacman;
import pacman.personnages.Personnage;

public class CaseTrappeTest {

	public void testIsAssociation(){
		CaseTrappe c1 = new CaseTrappe(1, 1, 'a');
		CaseTrappe c2 = new CaseTrappe(2, 1, 'a');
		assertEquals(true, c1.isAssociation(c2));
		CaseTrappe c3 = new CaseTrappe(1, 1, 'b');
		CaseTrappe c4 = new CaseTrappe(2, 1, 'c');
		assertEquals(false, c3.isAssociation(c4));
	}
	
	public void testHit() {
		Pacman p1 = new Pacman(0, 0);
		CaseTrappe c = new CaseTrappe(0, 0, 'a');
		assertEquals(true, c.hit(p1));
		Pacman p2 = new Pacman(0, 0);
		p2.deplacerDroite();
		assertEquals(false, c.hit(p2));
	}
}
