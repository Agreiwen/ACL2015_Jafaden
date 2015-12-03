package pacman.graphique.texture;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Texture {
	
	public ArrayList<Image> images;
	Image fantome;
	
	public Texture(){
		images = new ArrayList<Image>();
		ajoutDesImages();
	}
	
	public void ajoutDesImages(){
		Image pacman0 = new ImageIcon(this.getClass().getResource("../texture/pacman0.png")).getImage();
		Image pacman1 = new ImageIcon(this.getClass().getResource("../texture/pacman1.png")).getImage();
		Image pacman2 = new ImageIcon(this.getClass().getResource("../texture/pacman2.png")).getImage();
		Image pacman3 = new ImageIcon(this.getClass().getResource("../texture/pacman3.png")).getImage();
		images.add(pacman0);
		images.add(pacman1);
		images.add(pacman2);
		images.add(pacman3);
		images.add(fantome);
	}
	
	public Image getTexture(int i){
		return images.get(i);
	}
}
