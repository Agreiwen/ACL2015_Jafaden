package pacman.graphique.texture;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Texture {
	
	public ArrayList<Image> images;
	
	public Texture(){
		images = new ArrayList<Image>();
		ajoutDesImages();
	}
	
	public void ajoutDesImages(){
		for(int i=1; i<=16; i++){
			Image pacman = new ImageIcon(this.getClass().getResource("../texture/pacman"+i+".png")).getImage();
			images.add(pacman);
		}
		for(int i=1; i<=5; i++){
			Image fantome = new ImageIcon(this.getClass().getResource("../texture/fantome"+i+".png")).getImage();
			images.add(fantome);
		}
	}
	
	public Image getTextureMur(){
		Image mur = new ImageIcon(this.getClass().getResource("../texture/mur.png")).getImage();
		return mur;
	}
	
	public Image getTexture(int i){
		return images.get(i);
	}

	public Image getTextureCaseLibre() {
		Image mur = new ImageIcon(this.getClass().getResource("../texture/passage.png")).getImage();
		return mur;
	}
	
	public Image getTextureCaseTresor() {
		Image mur = new ImageIcon(this.getClass().getResource("../texture/coffre.png")).getImage();
		return mur;
	}
}
