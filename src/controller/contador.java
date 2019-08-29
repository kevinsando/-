package controller;

import static java.awt.Color.RED;
import javax.swing.JLabel;
import javax.swing.JTextField;
import vist.Game;

public class contador {

    public int puntaje = 0;
    JTextField tf = new JTextField();
    JLabel l1 = new JLabel();

    public contador() {
        

    }

    public void setPuntaje(int p) {
        puntaje = p;
    }

    public void mostrar(Game game) {
        l1.setText("Puntaje: ");
        tf.setText(Integer.toString(puntaje));
        tf.setForeground(RED);
        l1.move(230, 60);
        tf.move(290, 60);
        //tf.setVisible(true);
       // tf.show();
        game.add(l1);
        game.add(tf);
    }
}
