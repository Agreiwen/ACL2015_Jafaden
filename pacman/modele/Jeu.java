package pacman.modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import pacman.carte.CaseColle;
import pacman.carte.Case;
import pacman.carte.CaseLibre;
import pacman.carte.CaseMur;
import pacman.carte.CaseTrappe;
import pacman.carte.CaseTresor;
import pacman.carte.Labyrinthe;
import pacman.graphique.engine.Cmd;
import pacman.graphique.engine.Game;
import pacman.personnages.Fantome;
import pacman.personnages.Pacman;
import pacman.personnages.Personnage;
import pacman.personnages.Personnage.Direction;

public class Jeu implements Game{
	
	protected Labyrinthe laby;
	protected Pacman pacman;
	protected ArrayList<Fantome> fantomes;
	
	protected int timerInvincible;
	public static int TIMER_INVINCIBLE_START = 20;
    public enum Etat{ENCOURS,ENCOURS_INVINCIBLE,PERDU,GAGNER};
    private Etat etat = Etat.ENCOURS;
	
	public Jeu(Labyrinthe laby, Pacman pacman, String source){
		this.laby=laby;
		this.pacman=pacman;
		this.lireFichier(source);
		timerInvincible = TIMER_INVINCIBLE_START;
		this.fantomes = new ArrayList<Fantome>();
		fantomes.add(new Fantome(100, 150));
		fantomes.add(new Fantome(200, 100));
	}
	
	public ArrayList<Fantome> getFantomes() {
		return fantomes;
	}
	

	
	
//	CaseTrappe c1 = new CaseTrappe(25, 0);
//	CaseTrappe c2 = new CaseTrappe(450, 25);
//	c1.setDestination(c2);
//	c2.setDestination(c1);
//	trappes.add(c1);
//	trappes.add(c2);

	/**
	 * remplit le tableau de case, en instanciant diff�rents types selon le 
	 *  tableau d'entiers lu dans le fichier source. 
	 */
	@SuppressWarnings("static-access")
	private void lireFichier(String source) {
		Case[][] tabCases = new Case[laby.NB_LIGNE][laby.NB_COLONNE];
		char[][] tab = new char[laby.NB_LIGNE][laby.NB_COLONNE];
		Scanner sc = null;
        try {
            try {
                sc = new Scanner(new File(source));
                int i = 0;
                int j = 0;
                while (sc.hasNextLine()) {
                    for (char c : sc.next().toCharArray()) {
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
        
        for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				Case c = null;
				char lachar = tab[i][j];
				switch(lachar){
				case '0':
					c = new CaseLibre(i,j);
					break;
				case '1':
					c = new CaseMur(i,j);
					break;
				case '2':
					c = new CaseTresor(i,j);
					laby.setPosTresor(i, j);
					break;
				case '3':
					c = new CaseColle(i,j);
					laby.addCaseColle(c);
					break;
				default://il s'agit d'une lettre
					c = new CaseTrappe(i,j,lachar);
					laby.addCaseTrappe(c);
					break;
				}
				tabCases[i][j]=c;
			}
		}
        laby.setGrilleCases(tabCases);
        laby.linkTrappes();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < tab.length; i++) {
//			for (int j = 0; j < tab[0].length; j++) {
//				sb.append(tab[i][j]);
//				if(j == 19){
//					sb.append("\n");
//				}
//			}
//		}
//        System.out.println(sb.toString());
		
	}

	public void deplacerFantomes(){
		for (int i = 0;  i< fantomes.size(); i++) {
			fantomes.get(i).deplacer(this.pacman);
		}
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
	
	public Etat getEtat(){
		return etat;
	}
	
	
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
		this.deplacerFantomes();
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
		if(!pacman.isJustTeleported())
			checkTrappe();
	}
        
	
	private void checkTrappe() {
		CaseTrappe dest = laby.getDestination(pacman);
		if(dest != null){
			pacman.setHauteur(dest.getHauteur());
			pacman.setLargeur(dest.getLargeur());
			pacman.misAJourHitbox();
			pacman.setJustTeleported(true);
		}
	}

	public boolean estToucherParFantome(){
		boolean res = false;
		int i = 0;
		while(!res && i<fantomes.size()){
			Fantome fantome = fantomes.get(i);
			if(fantome.hit(pacman))
				res = true;
			i++;
		}
		return res;
	}
	
	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		if(etat == Etat.ENCOURS){
			if(estToucherParFantome()){
				pacman.perdreVie();
				if(pacman.mort()){
					etat = Etat.PERDU;
					System.out.println("Perdu");
					System.exit(0);
				}else{
					etat = Etat.ENCOURS_INVINCIBLE;
				}
			}else if((pacman.getHauteur()==laby.getHauteurTresor() && pacman.getLargeur()==laby.getLargeurTresor())){
				etat = Etat.GAGNER;
				System.out.println("Victoire");
				System.exit(0);
			}
		}else if(etat == Etat.ENCOURS_INVINCIBLE){
			timerInvincible--;
			if(timerInvincible==0){
				etat = Etat.ENCOURS;
				timerInvincible = TIMER_INVINCIBLE_START;
			}
		}
		return (etat == Etat.PERDU || etat == Etat.GAGNER);
	}
}
