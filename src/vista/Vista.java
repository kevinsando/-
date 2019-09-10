package vista;

import controller.Control;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.ABORT;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Vista extends JPanel implements Observer, ActionListener {

    private final Control control;
    public boolean enablee;
    private static final int B_WIDTH = 400;//borde
    private static final int B_HEIGHT = 400;//borde
    public JMenuBar mb = new JMenuBar();
    private static final int width = 300;
    private Timer timer;
    private static final int DELAY = 140;

    public Vista(Control control) {
        enablee = true;
        this.control = control;
        this.control.setVista(this);
        addKeyListener(control);
        setFocusable(true);
        iniciar();
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
    }

    public void initGame() {
        timer = new Timer(DELAY, this);
        timer.start();

    }

    @Override
    public void paint(Graphics g) {//bien
        super.paint(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //--------------------------Dibuja bola-----------------------
        g2d.drawOval(control.getXBall(), control.getYBall(), control.getDIAMETERBall(), control.getDIAMETERBall());
        g2d.fillOval(control.getXBall(), control.getYBall(), control.getDIAMETERBall(), control.getDIAMETERBall());

        //--------------------------Dibuja Raqueta----------------------
        g2d.drawRect(control.getXRaqueta(), control.getYRaqueta(), control.getWIDTHRaqueta(), control.getHEIGHTRaqueta());
        g2d.fillRect(control.getXRaqueta(), control.getYRaqueta(), control.getWIDTHRaqueta(), control.getHEIGHTRaqueta());

        //--------------------------Dibuja Circulo--------------------------
        g2d.drawOval(control.getTopXCirculo(), control.getTopYCirculo(), control.getWIDTHCirculo(), control.getWIDTHCirculo());

        mb.setVisible(true);
        mb.setBackground(Color.red);
        JMenu menu1 = new JMenu("File");
        JMenu menu2 = new JMenu("Edit");
        JMenu menu3 = new JMenu("About");
        mb.add(menu1);
        mb.add(menu2);
        mb.add(menu3);
        this.add(mb);
        if (enablee) {
            control.colisionBall();
            control.moveBall();
            control.mostrarContador();

        } else {
            gameOver();
        }
        repaint();
    }

    public void changeColor() {
        this.setBackground(Color.red);
    }

    private void gameOver() {//bien

        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    private void iniciar() {
        this.timer = new Timer(DELAY, this);
        this.timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {//borde

//        if (enablee) {
//
//            control.moveBall();//Snake
//        }
        repaint();
    }
}


/*----------------------------------------------------------
* Falta:
* Arreglo bolas
* Problema velocidad bola y raqueta
* Zonas
* Contador
*
*/