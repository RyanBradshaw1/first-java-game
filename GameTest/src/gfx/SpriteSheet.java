/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author Ryan
 */
public class SpriteSheet {
    
    private BufferedImage sheet;
    
    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }
    
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}
