/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.creatures;

import gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author Ryan
 */
public class Player extends Creature {
    
    public Player(float x, float y) {
        super(x, y);
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) x, (int) y, null);
    }
    
}
