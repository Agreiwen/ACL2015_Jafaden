package pacman.modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import pacman.carte.Labyrinthe;
import pacman.graphique.engine.Cmd;
import pacman.graphique.engine.Game;
import pacman.personnages.Pacman;
import pacman.personnages.Personnage;

public class Jeu implements Game{
	
	protected Labyrinthe laby;
	protected Pacman pacman;
	
	public Jeu(Labyrinthe laby, Pacman pacman, String source){
		this.laby=laby;
		this.pacman=pacman;
		int[][] tab = new int[laby.NB_LIGNE][laby.NB_COLONNE];
		Scanner sc = null;
        try {
            try {
                sc = new Scanner(new File(source));
                int i = 0;
                int j = 0;
                while (sc.hasNextLine()) {
                    for (char c : sc.next().toCharArray()) {
                    	//System.out.println(i+" "+j+" ");
                    	if(i == 0 && j == 20){
                        	break;
                        }
                        tab[i][j] = c;
                        i++;
                        if(i == 20){
                        	j++;
                        	i = 0;
                        }
                        
                        
                    }
                }
            } finally {
                if (sc != null)
                    sc.close();
            }
 
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				sb.append(tab[i][j]);
				if(j == 19){
					sb.append("\n");
				}
			}
		}
        System.out.println(sb.toString());
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
		if(caseLibre(p.getLargeur()-1, p.getHauteur())) p.deplacerGauche();
	}
	
	public void deplacerDroite(Personnage p) {
		if(caseLibre(p.getLargeur()+1, p.getHauteur()))p.deplacerDroite();
	}
	
	public void deplacerHaut(Personnage p) {
		if(caseLibre(p.getLargeur(), p.getHauteur()-1)) p.deplacerHaut();
	}
	
	public void deplacerBas(Personnage p) {
		if(caseLibre(p.getLargeur(), p.getHauteur()+1)) p.deplacerBas();
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
