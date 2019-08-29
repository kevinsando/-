
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
    public  int WIDTH = 100;
    public  int HEIGHT = 100;
    int Y;
    int X;
    Game game;
    
    
    public RaquetaPuntos(Game game, int x, int y){
        this.game = game;
        this.X = x;
        this.Y = y;
    }
    
    public void paint(Graphics2D g,  Color c,int x,int y, int w,int h,int sA, int aA,int tang) {
        WIDTH=w;
        HEIGHT=h;
        X= x;
        Y =y;
        g.drawArc(x, y, w, h, sA, aA);//z=145, k=45
        g.setColor(c);
        if(x>150){
        g.rotate(tang, x, y);
        }
    }
    
    public Rectangle getBounds() {
        return new Rectangle(X, Y, WIDTH, HEIGHT);
    }
    
    public boolean collision(){
        return game.ball.getBounds().intersects(getBounds());
    }
    
    public void rotar(double x,double y,double z, Graphics2D g){
        g.rotate(x, y, z);
    }
}
