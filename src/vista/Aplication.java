package vista;

import controller.Control;
import java.awt.EventQueue;
import javax.swing.JFrame;
import model.Modelo;

public class Aplication extends JFrame {

    public Aplication() {

        initUI();
    }

    private void initUI() {

        add(new Vista(new Control(new Modelo())));

        setResizable(false);
        pack();

        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame ex = new Aplication();
            ex.setVisible(true);
        });
    }
}
