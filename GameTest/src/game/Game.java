package game;


import display.Display;
import gfx.Assets;
import gfx.ImageLoader;
import gfx.SpriteSheet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import states.GameState;
import states.MenuState;
import states.OptionsState;
import states.State;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan
 */
public class Game implements Runnable {
    
    private Display display;
    public int width, height;
    
    public String title;
    
    private boolean running = false;
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //States
    private State gameState;
    private State menuState;
    private State optionsState;
    

    
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        
        
    }
    
    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(null);
        Assets.init();
        
        gameState = new GameState(this);
        menuState = new MenuState(this);
        optionsState = new OptionsState(this);
        State.setState(gameState);

    }
    
 
    
    private void tick() {
        if(State.getState() != null) {
            State.getState().tick();
        }
    }
    
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();
        //Clear Drawing
        g.clearRect(0, 0, width, height);
        
        //Start Drawing
        
        if(State.getState() != null) {
            State.getState().render(g);
        }
        
        
        //End Drawing
        
        bs.show();
        g.dispose();
    }
    
    public void run() {
        
        init();
        
        int fps = 60;
        double timePerTick = 1000000000 / fps; //1 billion nanosec in 1 sec
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        
        
        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            
            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            
            if(timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
            
        }
        
        stop();
    }
    
    public synchronized void start() {
        if(running) {
            return;
        } else {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }
        
        public synchronized void stop() {
            if(!running) {
                return;
            } else {
                try {
                    thread.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    
}
