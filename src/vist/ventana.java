
package vist;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.util.Random;
//import javax.swing.JPanel;

public class ventana extends JFrame {

    public ventana() {
        setSize(500,500);
        setTitle("DodgeBall");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void iniciarComponentes(){
        Random rand = new Random();
        JPanel panel = new JPanel();
        //panel.setLayout(null);
       // panel.setBackground(Color.red);
        this.getContentPane().add(panel);
        JRadioButton button1 = new JRadioButton();
        JLabel label1 = new JLabel(new ImageIcon("Bola-Patagonia-thumb-600x600_580x_07bdfaaf-6bba-4c02-95f2-49c0992af694_580x"));
        JLabel label2 = new JLabel("LABEL");
        label2.setForeground(Color.red);

        if(button1.isSelected()==true){
            label2.setBounds(rand.nextInt(50), rand.nextInt(50), 40, 30);
        }
        label1.setBounds(10, 10, 400, 300);
        panel.add(button1);
        panel.add(label1);
        panel.add(label2);
    }
    
}
