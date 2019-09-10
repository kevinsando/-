package model;

import java.awt.Rectangle;
import java.util.Observable;

public class Modelo extends Observable {

    private final Ball ball;
    private final Raqueta raqueta;
    private final Zona zona; //Arcos
    private final Circulo circ;//Pensar donde va
    private final Contador contador;//¿Pasar a vista?
    private final Ball[] balls;
    int k, tam;

    public Modelo() {
        this.raqueta = new Raqueta();
        this.zona = new Zona();
        this.circ = new Circulo();
        this.contador = new Contador();
        this.ball = new Ball(raqueta, contador, circ);
        k = 0;
        tam = 5;
        this.balls = new Ball[tam];

    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(null);
    }

    //--------------------------------BALL--------------------------------------
    public void moveBall() {
        ball.move(circ.getTopX(), circ.getTopY(), raqueta.getX(), raqueta.getY());
        setChanged();
        notifyObservers(null);
    }

    public boolean colisionBall() {
        ball.collision(raqueta.getBounds());
        return ball.isColision();

    }

    public Rectangle getBoundsBall() {
        return ball.getBounds();
    }

    public int getDIAMETERBall() {
        return ball.getDIAMETER();
    }

    public int getXBall() {
        return ball.getX();
    }

    public int getYBall() {
        return ball.getY();
    }

    public void addBall() {
        if (k < tam) {
            balls[k++] = new Ball();
        }
    }

    //------------------------------RAQUETA-------------------------------------
    public void moveRaqueta(boolean izquierda, boolean derecha, boolean arriba, boolean abajo) {
        raqueta.move(izquierda, derecha, arriba, abajo);
        setChanged();
        notifyObservers(null);
    }

    public Rectangle getBoundsRaqueta() {
        return raqueta.getBounds();
    }

    public int getYRaqueta() {
        return raqueta.getY();
    }

    public int getWIDTHRaqueta() {
        return raqueta.getWIDTH();
    }

    public int getHEIGHTRaqueta() {
        return raqueta.getHEIGHT();
    }

    public int getXRaqueta() {
        return raqueta.getX();
    }

    //--------------------------------Zona--------------------------------------
    public Rectangle getBoundsZona() {
        return zona.getBounds();
    }

    public boolean colisionZona() {
        return zona.collision();
    }

    //------------------------------Contador------------------------------------
    public void setPuntosContador(int i) {
        contador.setPuntaje(i);
        setChanged();
        notifyObservers(null);
    }

    public void mostrar() {
        contador.mostrar();
        setChanged();
        notifyObservers(null);
    }

    public boolean getJuego() {
        return ball.juego;
    }

    //------------------------------Circulo------------------------------------
    public int getTopYCirculo() {
        return circ.getTopY();
    }

    public int getTopXCirculo() {
        return circ.getTopX();
    }

    public int getWIDTHCirculo() {
        return circ.getWIDTH();
    }

}
