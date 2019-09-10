package controller;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import model.Modelo;
import vista.Vista;

/**
 *
 * @author Kevin
 */
public class Control implements KeyListener{

    private static final int DELAY = 140;
    private boolean right;
    private boolean left;
    private boolean up;
    private boolean down;
    private Modelo modelo;
    private Vista vista;
    Timer timer;

    public Control(Modelo modelo) {
        this.modelo = modelo;
        this.right = false;
        this.left = false;
        this.up = false;
        this.down = false;

    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }



    //--------------------------------BALL--------------------------------------
    public void moveBall() {
        modelo.moveBall();
    }

    public boolean colisionBall() {
        return modelo.colisionBall();
    }

    public Rectangle getBoundsBall() {
        return modelo.getBoundsBall();
    }

    public int getDIAMETERBall() {
        return modelo.getDIAMETERBall();
    }

    public int getXBall() {
        return modelo.getXBall();
    }

    public int getYBall() {
        return modelo.getYBall();
    }

    //------------------------------RAQUETA-------------------------------------
    public Rectangle getBoundsRaqueta() {
        return modelo.getBoundsRaqueta();
    }

    public int getYRaqueta() {
        return modelo.getYRaqueta();
    }

    public int getWIDTHRaqueta() {
        return modelo.getWIDTHRaqueta();
    }

    public int getHEIGHTRaqueta() {
        return modelo.getHEIGHTRaqueta();
    }

    public int getXRaqueta() {
        return modelo.getXRaqueta();
    }

    //--------------------------------Zona--------------------------------------
    public Rectangle getBoundsZona() {
        return modelo.getBoundsZona();
    }

    public boolean colisionZona() {
        return modelo.colisionZona();
    }

    //------------------------------Contador------------------------------------
    public void setPuntosContador(int i) {
        modelo.setPuntosContador(i);
    }

    public void mostrarContador() {
        modelo.mostrar();
    }
    //------------------------------Circulo------------------------------------

    public int getTopYCirculo() {
        return modelo.getTopYCirculo();
    }

    public int getTopXCirculo() {
        return modelo.getTopXCirculo();
    }

    public int getWIDTHCirculo() {
        return modelo.getWIDTHCirculo();
    }

    public boolean getJuego() {
        return modelo.getJuego();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.left = true;
            this.up = false;
            this.down = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.right = true;
            this.up = false;
            this.down = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.right = false;
            this.up = true;
            this.left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.right = false;
            this.down = true;
            this.left = false;
        }

        modelo.moveRaqueta(left, right, down, up);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



}
