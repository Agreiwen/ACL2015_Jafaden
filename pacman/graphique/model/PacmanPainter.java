package pacman.graphique.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import pacman.carte.Case;
import pacman.carte.CaseMur;
import pacman.carte.CaseTresor;
import pacman.carte.Labyrinthe;
import pacman.graphique.engine.GamePainter;
import pacman.modele.Jeu;
import pacman.graphique.texture.Texture;

import pacman.personnages.Pacman;
import pacman.personnages.Personnage.Direction;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */
public class PacmanPainter extends JComponent implements GamePainter {

	/**
	 * la taille des cases
	 */
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	Pacman pc;
	Labyrinthe laby;
	Jeu jeu;
	Texture texture;

	/**
	 * appelle constructeur parent
	 * 
	 * @param game
	 *            le jeutest a afficher
	 */

	

	public PacmanPainter(Pacman pc, Labyrinthe laby, Texture texture, Jeu jeu) {
		this.pc=pc;
		this.laby=laby;
		this.texture=texture;
		this.jeu=jeu;
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(BufferedImage im) {
		
		Graphics2D mur = (Graphics2D) im.getGraphics();
		mur.setColor(Color.black);
		Graphics2D tresor = (Graphics2D) im.getGraphics();
		tresor.setColor(Color.yellow);
		for (int i = 0; i < laby.getLargeurTabCase(); i++) {
			for (int j = 0; j < laby.getHauteurTabCase(); j++) {
				Case c = laby.getCase(i, j);
				if(c instanceof CaseMur){
					mur.fillRect(i*Labyrinthe.LARGEUR_CASE, j*Labyrinthe.HAUTEUR_CASE, 25, 25);
				}
				if(c instanceof CaseTresor){
					tresor.fillRect(i*Labyrinthe.LARGEUR_CASE, j*Labyrinthe.HAUTEUR_CASE, 25, 25);
				}
			}
		}
		
		Graphics2D pacman = (Graphics2D) im.getGraphics();
	    pacman.drawImage(choixImage(), pc.getLargeurGraphique(), pc.getHauteurGraphique(), 25, 25, this);

		for (int i = 0; i < jeu.getFantomes().size(); i++) {
			Graphics2D fantome = (Graphics2D) im.getGraphics();
			fantome.setColor(Color.red);
			fantome.fillOval(jeu.getFantomes().get(i).getLargeur(),jeu.getFantomes().get(i).getHauteur(),25,25);
		}
		
		//Graphics2D g2 = (Graphics2D) im.getGraphics();
	    //Image img1 = Toolkit.getDefaultToolkit().getImage("pacman/graphique/texture/pacman.png");
		//Image image = new ImageIcon(this.getClass().getResource("src/pacman/graphique/texture/pacman.png")).getImage();
//	    g2.drawImage(image, 100, 100, this);
//	    g2.finalize();
	}
	
	public Image choixImage(){
		Image im = texture.getTexture(0);
		switch(pc.getDirection()){
		case DROITE :
			im = texture.getTexture(0);
			break;
		case GAUCHE :
			im = texture.getTexture(1);
			break;
		case BAS :
			im = texture.getTexture(2);
			break;
		case HAUT :
			System.out.println("Haut");
			im = texture.getTexture(3);
			break;
		}
		return im;
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
