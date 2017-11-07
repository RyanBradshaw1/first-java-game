/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import game.Game;
import java.awt.Graphics;

/**
 *
 * @author Ryan
 */
public abstract class State {
    
    private static State currentState = null;
    
    public static void setState(State state) {
        currentState = state;
    }
    
    public static State getState() {
        return currentState;
    }
    
    //CLASS
    
    protected Game game;
    
    public State(Game game) {
        this.game = game;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
}
