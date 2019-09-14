package model;


import javafx.scene.shape.Circle;


public class Circulo {

    private static final int Y = 60;
    private static final int WIDTH = 280;
    

    int x;
    int xa;


    public Circulo() {
        this.x =20;
        this.xa=0;
    }

    public void move() {

    }


    public Circle getBounds() {
        return new Circle(x, Y, getWIDTH());
    }

    public int getTopY() {
        return Y;
    }

    public int getTopX() {
        return x;
    }

    public int getWIDTH() {
        return WIDTH;
    }
}
