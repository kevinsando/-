package vista;

import controller.Control;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.RED;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.ABORT;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Vista extends JPanel implements Observer, ActionListener {
    Image dibujo;
    private final Control control;
    public boolean enablee;
    private static final int B_WIDTH = 400;//borde
    private static final int B_HEIGHT = 400;//borde
    public JMenuBar mb = new JMenuBar();
    private static final int width = 300;
    private Timer timer;
    private final int DELAY = 10;
    
    public Vista(Control control) {
        ImageIcon iid = new ImageIcon("C:\\Users\\dell\\Documents\\Informatica\\Progra III\\DODGEBALL\\src\\vista\\fondo.png");
        dibujo= iid.getImage();
        enablee = true;
        this.control = control;
        this.control.setVista(this);
        this.control.agregarObservador(this);
       // this.setBackground(BLACK);
        addKeyListener(control);
        setFocusable(true);
        iniciar();
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        iniciarComponentes();
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

        //----------------------------Dibuja bola-------------------------
        g2d.drawImage(dibujo, 0, 0, this);
        g2d.setColor(RED);
        for (int i = 0; i < control.TamanoArreglo(); i++) {
            g2d.drawOval(control.getXBall(i), control.getYBall(i), control.getDIAMETERBall(i), control.getDIAMETERBall(i));
            g2d.fillOval(control.getXBall(i), control.getYBall(i), control.getDIAMETERBall(i), control.getDIAMETERBall(i));
        }
        g2d.setColor(BLACK);
        //--------------------------Dibuja Raqueta-------------------------
        g2d.drawRect(control.getXRaqueta(), control.getYRaqueta(), control.getWIDTHRaqueta(), control.getHEIGHTRaqueta());
        g2d.fillRect(control.getXRaqueta(), control.getYRaqueta(), control.getWIDTHRaqueta(), control.getHEIGHTRaqueta());
        
        //--------------------------Dibuja Circulo--------------------------
        g2d.drawOval(control.getTopXCirculo(), control.getTopYCirculo(), control.getWIDTHCirculo(), control.getWIDTHCirculo());

        //----------------------------Dibuja Zonas--------------------------
        g2d.setColor(Color.GREEN);
        //g2d.drawRect(control.getXZ(),control.getYZ(),control.getWIDTHZ(),control.getHEIGHTZ());//(x,y,w,h)
        g2d.drawLine(control.getXZ(), control.getYZ(), control.getWIDTHZ(), control.getHEIGHTZ());//(x1,y1,x2,y2)
        g2d.drawLine(300, 300, 250, 300);//(x1,y1,x2,y2)

    }
    
    public void changeColor() {
        this.setBackground(Color.red);
    }
    
    public void pausar() {
        timer.stop();
        repaint();
    }
    
    public void continuar() {
        timer.start();
        repaint();
    }
    
    private void iniciarComponentes() {
        JMenu menu1 = new JMenu("File");
        JMenu menu2 = new JMenu("Edit");
        JMenu menu3 = new JMenu("About");
        menu3.addActionListener(this.control);
        mb.add(menu1);
        mb.add(menu2);
        mb.add(menu3);
        mb.setLocation(1, 1);
        JMenu niveles = new JMenu("Niveles");
        menu2.add(niveles);
        JMenuItem item1 = new JMenuItem("Facil");
        JMenuItem item2 = new JMenuItem("Medio");
        JMenuItem item3 = new JMenuItem("Dificil");
        item1.addActionListener(this.control);
        item2.addActionListener(this.control);
        item3.addActionListener(this.control);
        niveles.add(item1);
        niveles.add(item2);
        niveles.add(item3);
        mb.setLocation(1, 1);
        this.add(mb);
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
        this.timer = new Timer(this.DELAY, this);
        this.timer.start();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {//borde
        mb.setVisible(true);
        mb.setBackground(Color.red);
        if (enablee) {
            for (int i = 0; i < control.TamanoArreglo(); i++) {
                control.colisionBall(i);
            }
            int puntaje = 0;
            JTextField tf;
            JLabel l1;
            tf = new JTextField();
            l1 = new JLabel();
            l1.setText("Puntaje: ");
            tf.setText(Integer.toString(puntaje));
            tf.setForeground(RED);
            l1.move(230, 60);
            tf.move(290, 60);
            if (control.getBoundsZona() == control.getBoundsBall(0)) {
                puntaje++;
                tf.setText(Integer.toString(puntaje));
            }
            this.add(l1);
            this.add(tf);
            control.moveBall();
            
            control.mostrarContador();
            
        } else {
            gameOver();
        }
    }
}


/*----------------------------------------------------------
* Falta:
* Arreglo bolas
* Problema velocidad bola
* Zonas
* Contador
*
 */
