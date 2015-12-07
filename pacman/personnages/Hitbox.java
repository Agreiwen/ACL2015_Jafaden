package pacman.personnages;

import java.awt.Rectangle;

public class Hitbox extends Rectangle {
	public Hitbox(int cx, int cy, int hauteur, int largeur){
		super(cx,cy,hauteur,largeur);
	}
	
	public void misAJour(int cx, int cy){
		x = cx;
		y = cy;
	}
	
	public String toString(){
		return "x : "+x+" y: "+y;
	}
}
