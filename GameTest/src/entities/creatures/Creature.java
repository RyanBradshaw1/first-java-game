/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.creatures;

import entities.Entity;

/**
 *
 * @author Ryan
 */
public abstract class Creature extends Entity{
    
    protected int health;
    
    public Creature(float x, float y) {
        super(x, y);
        health = 10;
    }
    
}
