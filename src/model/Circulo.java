package model;


import javafx.scene.shape.Circle;


public class Circulo {

    private static final int Y = 60;
    private static final int WIDTH = 280;
    
    //public Zona R3;
    int x;
    int xa;


    public Circulo() {
        this.x =20;
        this.xa=0;
    }

    public void move() {
//        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH) {
//            x = x + xa;
//        }
    }



//    public void keyReleased(KeyEvent e) {
//        xa = 0;
//    }
//
//    public void keyPressed(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            xa = -1;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            xa = 1;
//        }
//    }

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
