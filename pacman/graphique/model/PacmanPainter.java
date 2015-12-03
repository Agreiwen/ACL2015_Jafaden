package pacman.graphique.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import pacman.carte.Case;
import pacman.carte.CaseLibre;
import pacman.carte.CaseMur;
import pacman.carte.Labyrinthe;
import pacman.graphique.engine.GamePainter;
import pacman.personnages.Pacman;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */
public class PacmanPainter implements GamePainter {

	/**
	 * la taille des cases
	 */
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	Pacman pc;
	Labyrinthe laby;

	/**
	 * appelle constructeur parent
	 * 
	 * @param game
	 *            le jeutest a afficher
	 */
	public PacmanPainter(Pacman pc, Labyrinthe laby) {
		this.pc=pc;
		this.laby=laby;
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(BufferedImage im) {
		Graphics2D pacman = (Graphics2D) im.getGraphics();
		pacman.setColor(Color.blue);
		pacman.fillOval(pc.getLargeurGraphique(),pc.getHauteurGraphique(),25,25);
		Graphics2D mur = (Graphics2D) im.getGraphics();
		mur.setColor(Color.black);
		mur.fillOval(pc.getLargeurGraphique(),pc.getHauteurGraphique(),25,25);
		for (int i = 0; i < laby.getLargeurTabCase(); i++) {
			for (int j = 0; j < laby.getHauteurTabCase(); j++) {
				if(!laby.getCase(i, j).isAteignable()){
					mur.fillRect(i*Labyrinthe.LARGEUR_CASE, j*Labyrinthe.HAUTEUR_CASE, 25, 25);
				}
			}
		}
		
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

}
