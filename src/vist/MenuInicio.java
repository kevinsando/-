package vist;

import controller.contador;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class MenuInicio extends JPanel {

    public MenuInicio() {
    }

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game();
        JFrame frame = new JFrame("DODGEBALL");
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setSize(400, 400);
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
            game.c.mostrar(game);
            game.aumentPoint();
        }

    }

    @Override
    public int getWidth() {
        return 300;
    }
}
