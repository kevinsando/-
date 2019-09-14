package model;

import java.util.ArrayList;

public class ArregloBolas {

    private ArrayList<Ball> bolas;
    private int nivel;

    public ArregloBolas() {
        this.bolas = new ArrayList<>();
        this.nivel = 1;
        agregar();
    }

    public void agregar() {
        bolas.add(new Ball());
    }

    public void eliminar() {
        bolas.remove(bolas.size() - 1);
    }

    public Ball consultar(int i) {
        return bolas.get(i);
    }

    public int Tamano() {
        return bolas.size();
    }

    public void subirDeNivel(int i) {
        int n = nivel;
        this.nivel = i;
        if (n < i) {
            actualizarNivelArriba();
        } else {
            actualizarNivelAbajo(n);
        }
    }

    private void actualizarNivelArriba() {
        if (nivel == 2) {
            bolas.add(new Ball());
            bolas.add(new Ball());
        }
        if (nivel == 3 && bolas.size() == 3) {
            bolas.add(new Ball());
            bolas.add(new Ball());
        } else {
            if (nivel == 3 && bolas.size() == 1) {
                bolas.add(new Ball());
                bolas.add(new Ball());
                bolas.add(new Ball());
                bolas.add(new Ball());
            }
        }
    }

    private void actualizarNivelAbajo(int i) {
        if (nivel == 2 && i == 3) {
            bolas.remove(bolas.size() - 1);
            bolas.remove(bolas.size() - 1);
        }
        if (nivel == 1 && i == 3) {
            bolas.remove(bolas.size() - 1);
            bolas.remove(bolas.size() - 1);
            bolas.remove(bolas.size() - 1);
            bolas.remove(bolas.size() - 1);
        }
        if (nivel == 1 && i == 2) {
            bolas.remove(bolas.size() - 1);
            bolas.remove(bolas.size() - 1);
        }
    }

    public void colision() {
        if (nivel==2) {
            bolas.get(0).colisionBolas(bolas.get(1).getBounds(),bolas.get(1).getX(),bolas.get(1).getY());
        }
        if(nivel==3){
            bolas.get(0).colisionBolas(bolas.get(1).getBounds(),bolas.get(1).getX(),bolas.get(1).getY());
            bolas.get(0).colisionBolas(bolas.get(2).getBounds(),bolas.get(2).getX(),bolas.get(2).getY());
            bolas.get(0).colisionBolas(bolas.get(3).getBounds(),bolas.get(3).getX(),bolas.get(3).getY());
            bolas.get(1).colisionBolas(bolas.get(2).getBounds(),bolas.get(2).getX(),bolas.get(2).getY());
            bolas.get(1).colisionBolas(bolas.get(3).getBounds(),bolas.get(3).getX(),bolas.get(3).getY());
            bolas.get(2).colisionBolas(bolas.get(3).getBounds(),bolas.get(3).getX(),bolas.get(3).getY());

            
        }

    }

}
