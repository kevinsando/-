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
    private  int WIDTH = 55;
    private  int HEIGHT = 55;
    private int Y;
    private int X;
    boolean tipo;
    private Contador contador;
 //  Game game;
    
    
    public Zona(Contador cont, boolean tipo){
   //     this.game = game;
        this.X = 250;//x;
        this.Y = 170;//y;
        this.contador = cont;
        this.tipo = tipo;
    }
    
//    public void paint(Graphics2D g,  Color c,int x,int y, int w,int h,int sA, int aA,int tang) {//No va
//        WIDTH=w;
//        HEIGHT=h;
//        X= x;
//        Y =y;
//        g.drawArc(x, y, w, h, sA, aA);//z=145, k=45
//        g.setColor(c);
//        if(x>150){
//        g.rotate(tang, x, y);
//        }
//    }
    
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWIDTH(), getHEIGHT());
    }
    
    public boolean collision(){
       // return game.ball.getBounds().intersects(getBounds());
       return false;
    }
    
    public void choque(Ball bola){
        if(area().contains(bola.getX(), bola.getY()) && tipo == true){
            contador.setPuntaje(1);
        }
        if(area().contains(bola.getX(), bola.getY()) && tipo == false){
            contador.setPuntaje(-1);
        }
    }
    
    public void rotar(double x,double y,double z, Graphics2D g){//No va
        g.rotate(x, y, z);
    }
    
    private Rectangle area(){
        Rectangle r = new Rectangle(getX(), getY(), getWIDTH(), getHEIGHT());  
        return r.getBounds();
    }

    /**
     * @return the WIDTH
     */
    public int getWIDTH() {
        return WIDTH;
    }

    /**
     * @return the HEIGHT
     */
    public int getHEIGHT() {
        return HEIGHT;
    }

    /**
     * @return the Y
     */
    public int getY() {
        return Y;
    }

    /**
     * @return the X
     */
    public int getX() {
        return X;
    }
}
