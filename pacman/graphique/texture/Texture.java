package pacman.graphique.texture;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

public class Texture {
	
	public ArrayList<Image> images;
	Image pacman;
	Image fantome;
	
	public Texture(){
		images = new ArrayList<Image>();
		pacman = Toolkit.getDefaultToolkit().getImage("pacman.png");
		fantome = Toolkit.getDefaultToolkit().getImage("fantome.png");
		ajoutDesImages();
	}
	
	public void ajoutDesImages(){
		images.add(pacman);
		images.add(fantome);
	}
	
	public Image getTexture(int i){
		System.out.println(pacman);
		return images.get(i);
	}
}
