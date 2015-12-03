/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.personnages;

import java.awt.Rectangle;

/**
 *
 * @author audiger2u
 */
public class Hitbox extends Rectangle{
    
    /**
     * 
     * @param l largeur de la hitbox en pixel
     * @param h hauteur de la hitbox en pixel
     */
    public Hitbox(int l, int h){
        super(l, h);
    }
    
    public boolean collisionAvec(Hitbox h){
        return this.intersects(h);
    }
}
