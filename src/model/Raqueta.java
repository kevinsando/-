package model;

import java.awt.Rectangle;

public class Raqueta {//Modelo


    private final int WIDTH = 60;
    private final int HEIGHT = 10;

    private int x;
    private int y;
    int xa;
    int ya;

    public Raqueta() {
        this.x = 150;
        this.y = 330;
        this.xa = 1;
        this.ya = 1;

    }

    public void move(boolean izquierda, boolean derecha, boolean arriba, boolean abajo) {
        if (izquierda || derecha) {
            if (izquierda) {
                xa = -4;
            }
            if (derecha) {
                xa = +4;
            }
            x = x + xa;
        }
        if (arriba || abajo) {
            if (arriba) {
                ya = +1;
            }
            if (abajo) {
                ya = -1;
            }

            y = y + ya;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWIDTH(), getHEIGHT());
    }

    public int getTopY() {
        return getY();
    }

    public int getY() {
        return y;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getX() {
        return x;
    }

}
