
package controller;

import java.awt.Color;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
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
    private RaquetaPuntos R1;
    private RaquetaPuntos R2;

    public circulo(Game game) {
        this.game = game;
        this.R1 = new RaquetaPuntos(game, 240, 100);
        this.R2 = new RaquetaPuntos(game, 25, 100);
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH) {
            x = x + xa;
        }
    }

    public void paint(Graphics2D g) {
        //g.fillOval(x, Y, WIDTH, WIDTH);
        g.drawOval(x, Y, WIDTH, WIDTH);
        R1.paint(g, 200, RED);
        R2.paint(g, 200, RED);
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

