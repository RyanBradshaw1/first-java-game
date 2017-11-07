/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.awt.Graphics;

/**
 *
 * @author Ryan
 */
public abstract class Entity {
    
    protected float x,y;
    
    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
}
