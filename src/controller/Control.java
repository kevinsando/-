package controller;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import model.Ball;
import model.Modelo;
import vista.Vista;

/**
 *
 * @author Kevin
 */
public class Control implements KeyListener, ActionListener{

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
    public void agregarObservador(Observer ob){
        modelo.addObserver(ob);
    }
    public int getPuntaje(){
        return modelo.getPuntaje();
    }



    //--------------------------------BALL--------------------------------------
    public void moveBall() {
        modelo.moveBall();
    }

    public boolean colisionBall(int i) {
        return modelo.colisionBall(i);
    }

    public Rectangle getBoundsBall(int i) {
        return modelo.getBoundsBall(i);
    }

    public int getDIAMETERBall(int i) {
        return modelo.getDIAMETERBall(i);
    }
    
    public Ball getBola(int i) {
        return modelo.getBola(i);
    }

    public int getXBall(int i) {
        return modelo.getXBall(i);
    }

    public int getYBall(int i) {
        return modelo.getYBall(i);
    }
    
    public int TamanoArreglo(){
        return modelo.TamanoArreglo();
    }
    
    public void subirDeNivel(int i){
        modelo.subirDeNivel(i);
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
    
    public void choque(Ball bol){
        modelo.choque(bol);
    }
    
    public int getYZ() {
        return modelo.getXZ();
    }

    public int getXZ() {
        return modelo.getYZ();
    }
    public int getWIDTHZ() {
        return modelo.getWIDTHZ();
    }

    public int getHEIGHTZ() {
        return modelo.getHEIGHTZ();
    }
    //------------------------------Contador------------------------------------
    public void setPuntosContador(int i) {
        modelo.setPuntosContador(i);
    }

    public void mostrarContador() {
        modelo.mostrar();
    }
        public JLabel getTextoC() {
        return modelo.getTextoC();

    }

    public JTextField getPuntosC() {
        return modelo.getPuntosC();
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
            this.right = false;
            modelo.moveRaqueta(left, right, down, up);
            this.left = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.right = true;
            this.up = false;
            this.down = false;
            this.left = false;
            modelo.moveRaqueta(left, right, down, up);
            this.right = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.right = false;
            this.up = true;
            this.left = false;
            this.down = false;
            modelo.moveRaqueta(left, right, down, up);
            this.up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.right = false;
            this.down = true;
            this.left = false;
            this.up = false;
            modelo.moveRaqueta(left, right, down, up);
            this.down = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_P){
            vista.pausar();
        }
        if(e.getKeyCode() == KeyEvent.VK_O){
            vista.continuar();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem)e.getSource();
//        JMenu menu = (JMenu)e.getSource();
        if(item.getText().equals("Facil")){
            modelo.subirDeNivel(1);
        }
        if(item.getText().equals("Medio")){
            modelo.subirDeNivel(2);
        }
        if(item.getText().equals("Dificil")){
            modelo.subirDeNivel(3);
        }
//        if(menu.getText().equals("About")){
//            JOptionPane.showMessageDialog(this.vista, "               DODGEBALL 1.0. Programacion III. \n  Escuela de Informática. Universidad Nacional.  2019");
//        }
    }



}
