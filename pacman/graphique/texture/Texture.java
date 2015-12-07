package pacman.graphique.texture;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Texture {
	
	public ArrayList<Image> imagesPacman;
	public Image mur;
	public Image passage;
	public Image tresor;
	
	public Texture(){
		mur = new ImageIcon(this.getClass().getResource("../texture/mur.png")).getImage();
		passage = new ImageIcon(this.getClass().getResource("../texture/passage.png")).getImage();
		tresor = new ImageIcon(this.getClass().getResource("../texture/coffre.png")).getImage();
		imagesPacman = new ArrayList<Image>();
		ajoutDesImages();
	}
	
	public void ajoutDesImages(){
		for(int i=1; i<=16; i++){
			Image pacman = new ImageIcon(this.getClass().getResource("../texture/pacman"+i+".png")).getImage();
			imagesPacman.add(pacman);
		}
		for(int i=1; i<=5; i++){
			Image fantome = new ImageIcon(this.getClass().getResource("../texture/fantome"+i+".png")).getImage();
			imagesPacman.add(fantome);
		}
	}
	
	public Image getTexture(int i){
		return imagesPacman.get(i);
	}
	
	public Image getTextureMur(){
		return mur;
	}

	public Image getTextureCaseLibre() {
		return passage;
	}
	
	public Image getTextureCaseTresor() {
		return tresor;
	}
}
