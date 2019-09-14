package model;

import static java.awt.Color.RED;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Contador {

    public int puntaje;
    JTextField tf;
    JLabel l1; 

    public Contador() {
        this.puntaje =00;
        this.tf = new JTextField();
        this.l1 = new JLabel();
    }

    public void setPuntaje(int p) {
        puntaje += p;
    }

    public void mostrar() {
        l1.setText("Puntaje: ");
        tf.setText(Integer.toString(puntaje));
        tf.setForeground(RED);
        tf.setSize(50, 20);
        l1.move(150, 380);
        tf.move(200, 380);

    }
    public JLabel getTexto(){
        return l1;
        
    }
    public  JTextField getPuntos(){
        return tf;
    }
    public int getPuntaje(){
        return puntaje;
    }
}
