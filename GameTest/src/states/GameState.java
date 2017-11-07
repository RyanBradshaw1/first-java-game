/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import gfx.Assets;
import java.awt.Graphics;
import entities.creatures.Player;
import game.Game;






/**
 *
 * @author Ryan
 */
public class GameState extends State {
    
    private Player player;
    
    public GameState(Game game){
        super(game);
        
        player = new Player(100, 100);
    
}

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
        
        
        
    }
    
}
