package pacman.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pacman.tests.carte.CarteTests;
import pacman.tests.modele.ModeleTests;
import pacman.tests.personnages.PersonnagesTests;

@RunWith(Suite.class)
@SuiteClasses({CarteTests.class, ModeleTests.class, PersonnagesTests.class})
public class AllTests {

}
