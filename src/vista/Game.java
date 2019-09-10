package vista;

//package vist;
//
//import controller.Control;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.RenderingHints;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import model.Contador;
//import java.awt.Color;
//import java.util.Observable;
//import java.util.Observer;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//
//
//
//@SuppressWarnings("serial")
//public class Game extends JPanel implements Observer {
//    private final Control control;
//    public boolean enablee;
//
//    public JMenuBar mb = new JMenuBar();
//    private int width = 300;
//
//    public Game(Control control) {
//        this.control = control;
//        addKeyListener(control);
//    }
//
//    @Override
//    public void paint(Graphics g) {//bien
//        super.paint(g);
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);
//        //--------------------------Dibuja bola-----------------------
//        g2d.drawOval(control.getXBall(), control.getYBall(), control.getDIAMETERBall(), control.getDIAMETERBall());
//        g2d.fillOval(control.getXBall(), control.getYBall(), control.getDIAMETERBall(), control.getDIAMETERBall());
//        
//        //--------------------------Dibuja Raqueta----------------------
//        g2d.drawRect(control.getXRaqueta(), control.getYRaqueta(), control.getWIDTHRaqueta(), control.getHEIGHTRaqueta());
//        g2d.fillRect(control.getXRaqueta(), control.getYRaqueta(), control.getWIDTHRaqueta(), control.getHEIGHTRaqueta());
//        
//        //--------------------------Dibuja Circulo--------------------------
//        
//        g2d.drawOval(control.getTopXCirculo(), control.getTopYCirculo(), control.getWIDTHCirculo(), control.getWIDTHCirculo());
//        g2d.fillOval(control.getTopXCirculo(), control.getTopYCirculo(), control.getWIDTHCirculo(), control.getWIDTHCirculo());
//
//        mb.setVisible(true);
//        mb.setBackground(Color.red);
//        JMenu menu1 = new JMenu("File");
//        JMenu menu2 = new JMenu("Edit");
//        JMenu menu3 = new JMenu("About");
//        mb.add(menu1);
//        mb.add(menu2);
//        mb.add(menu3);
//        
//        if(!control.getJuego()){
//            gameOver();
//        }
//    }
//
//    private void gameOver() {//bien
//        
//        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
//        System.exit(ABORT);
//    }
//
//
//    @Override
//    public int getWidth() {
//        return width;
//    }
// @Override
//    public void update(Observable o, Object arg) {
//       repaint();
//    }
//
//}
