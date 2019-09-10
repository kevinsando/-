
package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

/**
 *
 * @author MIGUEL
 */
public class Zona {//Modelo
    public  int WIDTH = 100;
    public  int HEIGHT = 100;
    int Y;
    int X;
 //  Game game;
    
    
    public Zona( /*int x, int y*/){
   //     this.game = game;
        this.X = 1;//x;
        this.Y = 1;//y;
    }
    
    public void paint(Graphics2D g,  Color c,int x,int y, int w,int h,int sA, int aA,int tang) {//No va
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
       // return game.ball.getBounds().intersects(getBounds());
       return false;
    }
    
    public void rotar(double x,double y,double z, Graphics2D g){//No va
        g.rotate(x, y, z);
    }
}
