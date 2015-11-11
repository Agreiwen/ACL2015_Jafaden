package pacman.personnages;

public class Pacman {

	
	private int coordonneex;
	private int coordonneey;
	
	public Pacman(int x, int y){
		this.coordonneex = x;
		this.coordonneey = y;
		
	}
	
	public void deplacerGauche(){
		coordonneex--;
	}
	
	public void deplacerDroite(){
		coordonneex++;
	}
	public void deplacerHaut(){
		coordonneey++;
	}
	public void deplacerBas(){
		coordonneey--;
	}
	
	public int getCoordonneex() {
		return coordonneex;
	}

	public void setCoordonneex(int coordonneex) {
		this.coordonneex = coordonneex;
	}

	public int getCoordonneey() {
		return coordonneey;
	}

	public void setCoordonneey(int coordonneey) {
		this.coordonneey = coordonneey;
	}

	
}
