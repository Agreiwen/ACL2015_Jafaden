package pacman.graphique.model;

import java.awt.event.KeyEvent;

import pacman.graphique.engine.Cmd;
import pacman.graphique.engine.GameController;


/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * controleur de type KeyListener
 * 
 */
public class PacmanController implements GameController {

	/**
	 * commande en cours
	 */
	private Cmd commandeEnCours;
	
	/**
	 * construction du controleur par defaut le controleur n'a pas de commande
	 */
	public PacmanController() {
		this.commandeEnCours = Cmd.IDLE;
	}

	/**
	 * quand on demande les commandes, le controleur retourne la commande en
	 * cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Cmd getCommand() {
		return this.commandeEnCours;
	}

	@Override
	/**
	 * met a jour les commandes en fonctions des touches appuyees
	 */
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			this.commandeEnCours = Cmd.LEFT;
			break;
		case KeyEvent.VK_RIGHT:
			this.commandeEnCours = Cmd.RIGHT;
			break;
		case KeyEvent.VK_DOWN:
			this.commandeEnCours = Cmd.DOWN;
			break;
		case KeyEvent.VK_UP:
			this.commandeEnCours = Cmd.UP;
			break;
		default:
			this.commandeEnCours = Cmd.IDLE;
		}
	}

	
	

	
	
	

	@Override
	/**
	 * met a jour les commandes quand le joueur relache une touche
	 */
	public void keyReleased(KeyEvent e) {
		this.commandeEnCours = Cmd.IDLE;
	}

	@Override
	/**
	 * ne fait rien
	 */
	public void keyTyped(KeyEvent e) {

	}

}
