package pacman.modele;

import pacman.carte.Labyrinthe;
import pacman.graphique.engine.Cmd;
import pacman.graphique.engine.Game;
import pacman.personnages.Pacman;
import pacman.personnages.Personnage;

public class Jeu implements Game{
	
	protected Labyrinthe laby;
	protected Pacman pacman;
	
	public Jeu(Labyrinthe laby, Pacman pacman){
		this.laby=laby;
		this.pacman=pacman;
	}
	
	public Pacman getPacman() {
		return pacman;
	}
	
	public void setPacman(Pacman pacman) {
		this.pacman = pacman;
	}
	
	public boolean caseLibre(int poslargeur, int poshauteur){
		return laby.estLibre(poslargeur, poshauteur);
	}
	
	
	public int getHauteurPersonnage(Personnage p){
		return(p.getHauteur());
	}
	
	public int getLargeurPersonnage(Personnage p){
		return(p.getLargeur());
	}
	
	/**
	 * Methodes de deplacement d'un personnage
	 */
	
	
	
	/* PROBLEME DE PROPOTIONS Tab/Laby graphique */
	public void deplacerGauche(Personnage p) {
		if(laby.estLibre(p.getLargeur()-1, p.getHauteur())) p.deplacerGauche();
	}
	
	public void deplacerDroite(Personnage p) {
		if(laby.estLibre(p.getLargeur()+1, p.getHauteur()))p.deplacerDroite();
	}
	
	public void deplacerHaut(Personnage p) {
		if(laby.estLibre(p.getLargeur(), p.getHauteur()-1)) p.deplacerHaut();
	}
	
	public void deplacerBas(Personnage p) {
		if(laby.estLibre(p.getLargeur(), p.getHauteur()+1)) p.deplacerBas();
	}
	
	public String toString(){
		StringBuilder st = new StringBuilder();
		st.append("Labyrinthe : \n");
		for (int i = laby.getLargeur()-1; i >= 0; i--) {
			for (int j = 0; j < laby.getHauteur(); j++) {
				if(j==pacman.getLargeur() && i==pacman.getHauteur()){
					st.append("X");
				}else st.append("0");
			}
			st.append("\n");
		}
		st.append("\n");
		return st.toString();
	}
	
	
	
	
	
	
	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */
	@Override
	public void evolve(Cmd commande) {
		//System.out.println("Execute "+commande);
		if(commande == Cmd.RIGHT){
			deplacerDroite(pacman);
		}
		if(commande == Cmd.LEFT){
			deplacerGauche(pacman);
		}
		if(commande == Cmd.DOWN){
			deplacerBas(pacman);
		}
		if(commande == Cmd.UP){
			deplacerHaut(pacman);
		}
		//System.out.println(pacman.getLargeur()+" "+pacman.getHauteur());
	}

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		// le jeu n'est jamais fini
		return false;
	}

}
