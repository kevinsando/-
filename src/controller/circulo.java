
package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javafx.scene.shape.Circle;
import vist.Game;
public class circulo {
    private static final int Y = 60;
    private static final int WIDTH = 280;


    int x = 20;
    int xa = 0;
    private Game game;

    public circulo(Game game) {
        this.game = game;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH) {
            x = x + xa;
        }
    }

    public void paint(Graphics2D g) {
        //g.fillOval(x, Y, WIDTH, WIDTH);
        g.drawOval(x, Y, WIDTH, WIDTH);
        //g.setColor(Color.red);

    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -1;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = 1;
        }
    }

    public Circle getBounds() {
        return new Circle(x, Y, WIDTH);
    }

    public int getTopY() {
        return Y;
    }
    public int getTopX() {
        return x;
    }
}

