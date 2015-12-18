package pacman.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import pacman.tests.carte.CaseTrappeTest;
import pacman.tests.carte.LabyrintheTest;
import pacman.tests.modele.JeuTest;
import pacman.tests.personnages.PersonnageTest;

public class TestRunner {
   public static void main(String[] args) {
	      Result resultJeuTest = JUnitCore.runClasses(JeuTest.class);
	      for (Failure failure : resultJeuTest.getFailures()) {
	         System.out.println(failure.toString());
	      }

	      Result resultLabyrintheTest = JUnitCore.runClasses(LabyrintheTest.class);
	      for (Failure failure : resultLabyrintheTest.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      
	      Result resultPersonnageTest = JUnitCore.runClasses(PersonnageTest.class);
	      for (Failure failure : resultPersonnageTest.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      
	      System.out.println("PersonnageTest : "+resultPersonnageTest.wasSuccessful());
	      System.out.println("LabyrintheTest : "+resultLabyrintheTest.wasSuccessful());
	      System.out.println("JeuTest : "+resultJeuTest.wasSuccessful());
	   }
}

