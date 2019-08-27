/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import vist.Game;
/**
 *
 * @author MIGUEL
 */
public class RaquetaPuntos {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;
    int Y;
    int X;
    Game game;
    
    
    public RaquetaPuntos(Game game, int x, int y){
        this.game = game;
        this.X = x;
        this.Y = y;
    }
    
    public void paint(Graphics2D g, double x, Color c) {
        g.drawArc(X, Y, WIDTH, HEIGHT, 90, 90);
        g.setColor(c);
//        AffineTransform orig = g.getTransform();
//        g.rotate(Math.toRadians(90));
//        g.setTransform(orig);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(X, Y, WIDTH, HEIGHT);
    }
    
    public boolean collision(){
        return game.ball.getBounds().intersects(getBounds());
    }
    
    public void rotar(double x, Graphics2D g){
        g.rotate(x);
    }
}
