package vist;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controller.Ball;
import controller.Raqueta;
import controller.RaquetaPuntos;
import controller.circulo;
import controller.contador;
import java.awt.Color;
import static java.awt.Color.GREEN;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import model.arregloBalls;


@SuppressWarnings("serial")
public class Game extends JPanel {
    private arregloBalls arrB = new arregloBalls(this);
    public boolean enablee;
    public Ball ball = new Ball(this);
    public Raqueta racquet = new Raqueta(this);
    public circulo circTab = new circulo(this);
    public RaquetaPuntos R1 = new RaquetaPuntos(this, 240, 100);
    private RaquetaPuntos R2 = new RaquetaPuntos(this, 240, 100);
    private RaquetaPuntos R3 = new RaquetaPuntos(this, 240, 100);
    public contador c = new contador();
    public JMenuBar mb = new JMenuBar();
    private int width = 300;

    public Game() {//bien
//        this.setLocation(null);
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

    void move() {//bien
        ball.move();
        racquet.move();

    }

    @Override
    public void paint(Graphics g) {//bien
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        racquet.paint(g2d);
        circTab.paint(g2d);
        mb.setVisible(true);
        mb.setBackground(Color.red);
        JMenu menu1 = new JMenu("File");
        JMenu menu2 = new JMenu("Edit");
        JMenu menu3 = new JMenu("About");
        mb.add(menu1);
        mb.add(menu2);
        mb.add(menu3);
 
       // mb.move(10, 10);
        //this.add(mb);
        // c.mostrar(this);

        //x, y,  width,    height,  startAngle,arcAngle,tangente
        R1.paint((Graphics2D) g, Color.RED, 0, 0, 0, 0, 0, 0, 0);
        R2.paint((Graphics2D) g, GREEN, 20, 80, 300, 200, 140, 40, 500);
        R3.paint((Graphics2D) g, Color.WHITE, 295, 80, 3, 230, 170, 40, 00);
        R3.rotar(500, 100, 200, g2d);

    }

    public void gameOver() {//bien
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    //public static void main(String[] args) throws InterruptedException {
//        Game game = new Game();
//        JFrame frame = new JFrame("DODGEBALL");
//        //MenuInicio mi = new MenuInicio();
//        //mi.show();
//        //game.setVisible(false);
//        //if (mi.stade) {
//            //mi.setVisible(false);
//            frame.setLocationRelativeTo(null);
//
//            //game.contador();
//            game.aumentPunt();
//            frame.add(game);
//            frame.setSize(400, 400);
//            frame.setVisible(true);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            while (true) {
//                game.move();
//                game.repaint();
//                Thread.sleep(10);
//            }
    // }
    // }
    @Override
    public int getWidth() {
        return width;
    }

    public void aumentPoint() {//controlador
        if (ball.collision()) {
            c.puntaje++;
        }
    }

}
