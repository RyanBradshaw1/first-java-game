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
public class Assets {
    
    public static final int width = 86, height = 86;
    
    public static BufferedImage player, grass, dirt, npc, tree;
    
    public static void init() {
        
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sprite5.png"));
        
        player = sheet.crop(0, 0, width, height);
        npc = sheet.crop(width, 0, width, height);
        grass = sheet.crop(width * 2, 0, width, height);
        dirt = sheet.crop(width * 3, 0, width, height);
        tree = sheet.crop(0, height, width, height);
        
        
    }
    
}
