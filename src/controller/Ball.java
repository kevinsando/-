/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javafx.scene.shape.Circle;
import vist.Game;

public class Ball {

    private static final int DIAMETER = 30;
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private Game game;


    public Ball(Game aThis) {
       this.game = aThis;
    }

    public void move() {
        if (x + xa < 40) {//Borde Izquierdo
            xa = 1;
        }
        if (x + xa > game.circTab.getTopY() + 6.2*DIAMETER) {//Borde Derecho
            xa = -1;
        }
        if (y + ya < game.circTab.getTopX() - DIAMETER+80) {
            ya = 1;
        }
        if (y + ya > game.getHeight() - DIAMETER) {
            game.gameOver();
        }
        if (collision()) {
            ya = -1;
            y = game.racquet.getTopY() - DIAMETER;
            //y = game.circTab.getTopY() - DIAMETER;

        }
        x = x + xa;
        y = y + ya;
    }

    public boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());

    }

//    public void paint(Graphics2D g) {
//        g.fillOval(x, y, DIAMETER, DIAMETER);
//    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
    public Circle getBoundsc(){
        return new Circle(x, y, DIAMETER);
}

    public void paint(Graphics2D g2d) {
       
        g2d.fillOval(x, y, DIAMETER, DIAMETER);
    }

}
