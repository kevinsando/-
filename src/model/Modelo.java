package model;

import java.awt.Rectangle;
import java.util.Observable;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Modelo extends Observable {

    private final Ball ball;
    private final Raqueta raqueta;
    private final Zona zona;
    private ArregloZonas zonas;
    private final Circulo circ;
    private final Contador contador;
    private final ArregloBolas bolas;

    public Modelo() {
        this.raqueta = new Raqueta();
        this.contador = new Contador();
        this.zona = new Zona(245, 170, contador, true);
        this.zonas = new ArregloZonas();
        this.zonas.iniciarZonas(contador);
        this.circ = new Circulo();
        this.ball = new Ball();
        this.bolas = new ArregloBolas();

    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(null);
    }

    //--------------------------------BALL--------------------------------------
    public void moveBall() {
        for (int i = 0; i < bolas.Tamano(); i++) {
            bolas.consultar(i).move(circ.getTopX(), circ.getTopY(), raqueta.getX(), raqueta.getY(), contador);
        }
        setChanged();
        notifyObservers(null);
    }

    public boolean colisionBall(int i) {
        bolas.consultar(i).collision(raqueta.getBounds());
        return bolas.consultar(i).isColision();

    }

    public Rectangle getBoundsBall(int i) {
        return bolas.consultar(i).getBounds();
    }

    public int getDIAMETERBall(int i) {
        return bolas.consultar(i).getDIAMETER();
    }

    public int getXBall(int i) {
        return bolas.consultar(i).getX();
    }

    public int getYBall(int i) {
        return bolas.consultar(i).getY();
    }

    public Ball getBola(int i) {
        return bolas.consultar(i);
    }

    public int TamanoArreglo() {
        return bolas.Tamano();
    }
    public void colisionBolas(){
        bolas.colision();
    }

    public void subirDeNivel(int i) {
        bolas.subirDeNivel(i);
        setChanged();
        notifyObservers(null);
    }
    public void contadorPuntos(){
        ball.colisionPuntos(zona.getBounds(), contador);
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

   public int getXZ(){
        return zona.getX();
    }
    
    public int getYZ(){
        return zona.getY();
    }
    
    public int getWIDTHZ(){
        return zona.getWIDTH();
    }
    
    public int getHEIGHTZ(){
        return zona.getHEIGHT();
    }
    
    public void choque(Ball bol){
        zonas.choque(bol);
        setChanged();
        notifyObservers(null);
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

    public JLabel getTextoC() {
        return contador.getTexto();

    }

    public JTextField getPuntosC() {
        return contador.getPuntos();
    }
        public int getPuntaje() {
        return contador.getPuntaje();
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
