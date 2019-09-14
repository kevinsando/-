package model;

import java.awt.Rectangle;

public class Zona {

    private int WIDTH;
    private int HEIGHT;
    private int Y;
    private int X;
    boolean tipo;
    boolean puntoSumado;
    private Contador contador;

    public Zona(int x, int y, Contador cont, boolean tipo) {

        this.WIDTH = 55;
        this.HEIGHT = 55;
        this.X = x;//x;
        this.Y = y;//y;
        this.contador = cont;
        this.tipo = tipo;
        this.puntoSumado = false;
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWIDTH(), getHEIGHT());
    }

    public boolean collision() {
        return false;
    }

    public void choque(Ball bola) {
        if (area().contains(bola.getX(), bola.getY())) {
            if (tipo == true && puntoSumado == false) {
                contador.setPuntaje(1);
                puntoSumado = true;
            }
        } else {
            puntoSumado = false;
        }
        if (area().contains(bola.getX(), bola.getY())) {
            if (tipo == false && puntoSumado == false) {
                contador.setPuntaje(-1);
                puntoSumado = true;
            }
        } else {
            puntoSumado = false;
        }
    }

    private Rectangle area() {
        Rectangle r = new Rectangle(getX(), getY(), getWIDTH(), getHEIGHT());
        return r.getBounds();
    }
    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getY() {
        return Y;
    }

    public int getX() {
        return X;
    }
}
