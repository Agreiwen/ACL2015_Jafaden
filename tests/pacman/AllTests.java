package pacman;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pacman.carte.CarteTests;
import pacman.carte.LabyrintheTest;
import pacman.modele.ModeleTests;
import pacman.personnages.PersonnagesTests;

@RunWith(Suite.class)
@SuiteClasses({CarteTests.class, ModeleTests.class, PersonnagesTests.class})
public class AllTests {

}
