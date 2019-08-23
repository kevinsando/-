package vist;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controller.Ball;
import controller.Raqueta;
import controller.circulo;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import vist.MenuInicio;

@SuppressWarnings("serial")
public class Game extends JPanel {

    public boolean enablee;
    public Ball ball = new Ball(this);
    public Raqueta racquet = new Raqueta(this);
    public circulo circTab = new circulo(this);

    private int width = 300;

    public Game() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
                circTab.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);
                circTab.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    private void move() {
        ball.move();
        racquet.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        racquet.paint(g2d);
        circTab.paint(g2d);

        //g.drawOval( 10, 30, 290, 300 );
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame("DODGEBALL");
        // frame.setContentPane(new JLabel(new ImageIcon("Bola-Patagonia-thumb-600x600_580x_07bdfaaf-6bba-4c02-95f2-49c0992af694_580x.png")));
        frame.setLocationRelativeTo(null);
        Game game = new Game();
        frame.add(game);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }

    }

    @Override
    public int getWidth() {
        return width;
    }
}
