package vista;

import controller.Control;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import model.Modelo;

public class Aplication extends JFrame {

    public Aplication() {

        initUI();
    }

    private void initUI() {
        this.setBackground(Color.black);
        add(new Vista(new Control(new Modelo())));

        setResizable(false);
        pack();

        setTitle("Dodge Ball");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.black);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame ex = new Aplication();
            ex.setBackground(Color.black);
            
            ex.setVisible(true);
            ex.setBackground(Color.black);
        });
    }
}
