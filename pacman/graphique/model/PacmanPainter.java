package pacman.graphique.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import pacman.carte.Case;
import pacman.carte.CaseMur;
import pacman.carte.CaseLibre;
import pacman.carte.CaseTresor;
import pacman.carte.Labyrinthe;
import pacman.graphique.engine.GamePainter;
import pacman.graphique.texture.Texture;
import pacman.modele.Jeu;
import pacman.personnages.Pacman;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */
@SuppressWarnings("serial")
public class PacmanPainter extends JComponent implements GamePainter {

	/**
	 * la taille des cases
	 */
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	public static final int X_COEUR1 = 350;
	public static final int X_COEUR2 = 385;
	public static final int X_COEUR3 = 420;
	public static final int Y_COEURS = 0;
	public Pacman pc;
	public Labyrinthe laby;
	public Jeu jeu;
	public Texture texture;
	public int numeroImagePacman = 0;
	public int numeroImageFantome = 16;
	
	

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
		if(numeroImagePacman < 3){
			numeroImagePacman++;
		}else{
			numeroImagePacman = 0;
		}
		Graphics2D mur = (Graphics2D) im.getGraphics();
		mur.setColor(Color.black);
		Graphics2D tresor = (Graphics2D) im.getGraphics();
		tresor.setColor(Color.yellow);
		for (int i = 0; i < laby.getLargeurTabCase(); i++) {
			for (int j = 0; j < laby.getHauteurTabCase(); j++) {
				Case c = laby.getCase(i, j);
				if(c instanceof CaseMur){
					mur.drawImage(texture.getTextureMur(),i*Labyrinthe.LARGEUR_CASE,  j*Labyrinthe.HAUTEUR_CASE, 25, 25, this);
					//mur.fillRect(i*Labyrinthe.LARGEUR_CASE, j*Labyrinthe.HAUTEUR_CASE, 25, 25);
				}
				if(c instanceof CaseLibre){
					mur.drawImage(texture.getTextureCaseLibre(),i*Labyrinthe.LARGEUR_CASE,  j*Labyrinthe.HAUTEUR_CASE, 25, 25, this);
				}
				if(c instanceof CaseTresor){
//					tresor.fillRect(i*Labyrinthe.LARGEUR_CASE, j*Labyrinthe.HAUTEUR_CASE, 25, 25);
					tresor.drawImage(texture.getTextureCaseLibre(),i*Labyrinthe.LARGEUR_CASE,  j*Labyrinthe.HAUTEUR_CASE, 25, 25, this);
					tresor.drawImage(texture.getTextureCaseTresor(),i*Labyrinthe.LARGEUR_CASE,  j*Labyrinthe.HAUTEUR_CASE, 25, 25, this);
				}
			}
		}
		
		Graphics2D pacman = (Graphics2D) im.getGraphics();
	    pacman.drawImage(choixImagePacman(numeroImagePacman), pc.getLargeurGraphique(), pc.getHauteurGraphique(), 25, 25, this);

	    // TODO une texture par fantome a faire et donc une methode choixImageFantome quand elles seront pretes.
		for (int i = 0; i < jeu.getFantomes().size(); i++) {
			Graphics2D fantome = (Graphics2D) im.getGraphics();
			fantome.drawImage(texture.getTexture(17), jeu.getFantomes().get(i).getLargeur(), jeu.getFantomes().get(i).getHauteur(), 25, 25, this);
		}
		Graphics2D vie = (Graphics2D) im.getGraphics();
		printVie(vie, texture);
	}
	
	private void printVie(Graphics2D vie,Texture t){
		Image textureCoeur1 = pc.getVie()<1?t.getTextureCoeurVide():t.getTextureCoeur();
		Image textureCoeur2 = pc.getVie()<2?t.getTextureCoeurVide():t.getTextureCoeur();
		Image textureCoeur3 = pc.getVie()<3?t.getTextureCoeurVide():t.getTextureCoeur();
		
		vie.drawImage(textureCoeur1,X_COEUR1,  Y_COEURS, 25, 25, this);
		vie.drawImage(textureCoeur2,X_COEUR2,  Y_COEURS, 25, 25, this);
		vie.drawImage(textureCoeur3,X_COEUR3,  Y_COEURS, 25, 25, this);
	}
	
	public Image choixImagePacman(int i){
		Image im = texture.getTexture(0);
		switch(pc.getDirection()){
		case DROITE :
			// image 1 a 4
			im = texture.getTexture(0+i);
			break;
		case GAUCHE :
			// image 5 a 8
			im = texture.getTexture(4+i);
			break;
		case BAS :
			// image 9 a 12
			im = texture.getTexture(8+i);
			break;
		case HAUT :
			// image 13 a 16
			im = texture.getTexture(12+i);
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
