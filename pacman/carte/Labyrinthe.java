package pacman.carte;

import java.util.ArrayList;

import pacman.personnages.Pacman;
import pacman.personnages.Personnage;

public class Labyrinthe {

	public static final int NB_COLONNE = 20;
	public static final int NB_LIGNE = 20;
	protected int[][] grille;
	protected int largeur;
	protected int hauteur;
	public static int LARGEUR_CASE = 25;
	public static int HAUTEUR_CASE = 25;
	protected ArrayList<CaseTrappe> trappes;
	protected ArrayList<CaseColle> colles;
	
	
	protected Case[][] tabCases;
	protected int largeurTresor;
	protected int hauteurTresor;
	
	//protected Pacman pacman;
	
	/**
	 * 
	 * @param largeur la largeur du labyrinthe
	 * @param hauteur la hauteur du labyrinthe
	 */
	public Labyrinthe(int largeur, int hauteur){
		grille = new int[largeur][hauteur];
		tabCases = new Case[largeur][hauteur];
		this.largeur = largeur;
		this.trappes = new ArrayList<CaseTrappe>();
		this.hauteur = hauteur;
	}

	public int[][] getGrille() {
		return grille;
	}


	public void setGrille(int[][] grille) {
		this.grille = grille;
	}
	
	public void setGrilleCases(Case[][] grille){
		this.tabCases = grille;
	}


	public int getLargeur() {
		return largeur;
	}

	/**
	 * Teste si une position dans le labyrinthe est disponible, pour pouvoir s'y deplacer
	 * @param largeur
	 * @param hauteur 
	 * @return 
	 */
	public boolean estLibre(int largeur, int hauteur){
		boolean rep = true;
		
		/* Tests bords de map */
		if(largeur < 0)
			rep = false;
		else if((largeur >= (this.largeur))){
			rep = false;
		}else if((hauteur < 0)){
			rep = false;
		}else if((hauteur >= (this.hauteur))){
			rep = false;
		}
		
		/* Test Murs */
		if(rep){
			Case c = getCase(largeur, hauteur);
			rep = c.isAteignable();
		}
		return rep;
	}
	


	public int getHauteur() {
		return hauteur;
	}
	
	/**
	 * 
	 * @param largeur
	 * @param hauteur
	 * @return une case du labyrinthe
	 */
	public Case getCase(int largeur, int hauteur){
		return tabCases[largeur][hauteur];
	}

	public int getLargeurTabCase(){
		return tabCases.length;
	}
	
	public int getHauteurTabCase(){
		return tabCases[0].length;
	}
	
	public void setPosTresor(int largeur, int hauteur){
		this.largeurTresor=largeur;
		this.hauteurTresor=hauteur;
	}
	
	public int getLargeurTresor(){
		return this.largeurTresor;
	}
	
	public int getHauteurTresor(){
		return this.hauteurTresor;
	}
	
	public void addCaseTrappe(Case c){
		trappes.add((CaseTrappe) c);
	}
	
	public void addCaseColle(Case c){
		colles.add((CaseColle) c);
	}
	public CaseTrappe getDestination(Pacman p){
		CaseTrappe res = null;
		boolean trouv = false;
		int i = 0;
		while(!trouv && i < trappes.size()){
			CaseTrappe c = trappes.get(i);
			if(c.hit(p)){
				trouv = true;
				res = c.getDestination();
			}
			i++;
		}
		return res;
	}
	
	public void linkTrappes(){
		for(CaseTrappe c : trappes){
			makeAssociation(c);
		}
	}
	
	private void makeAssociation(CaseTrappe t){
		CaseTrappe res = null;
		boolean trouv = false;
		int i = 0;
		while(!trouv && i< trappes.size()){
			CaseTrappe c = trappes.get(i);
			if(!c.equals(t)){//si la case en cours n'est pas celle de depart
				if(c.isAssociation(t)){
					t.setDestination(c);
				}
			}
			i++;
		}
	}
	
	public boolean isColle(Personnage p){
			for(int i=0;i<colles.size();i++){
				CaseColle c = colles.get(i);
				if(c.hit(p))return true;
			}
			return false;
	}
}
