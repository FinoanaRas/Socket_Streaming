package graphics;
import javax.swing.*;
import java.awt.*;
import utilities.*;
import threadclient.*;
public class ControlPanel extends JPanel{
    public ControlPanel(ClientThread ct){
        display(ct);
    }
    public void display(ClientThread ct){
        JButton bouton = new JButton("play");
        bouton.setSize(50,50);
        bouton.addMouseListener(new ButtonListener(ct,bouton));
        add(bouton);
        JButton bouton2 = new JButton("pause");
        bouton2.setSize(50,50);
        bouton2.addMouseListener(new ButtonListener(ct,bouton2));
        add(bouton2);
        JButton bouton3 = new JButton("stop");
        bouton3.setSize(50,50);
        bouton3.addMouseListener(new ButtonListener(ct,bouton3));
        add(bouton3);
        JButton bouton4 = new JButton("previous");
        bouton4.setSize(50,50);
        bouton4.addMouseListener(new ButtonListener(ct,bouton4));
        add(bouton4);
        JButton bouton5 = new JButton("next");
        bouton5.setSize(50,50);
        bouton5.addMouseListener(new ButtonListener(ct,bouton5));
        add(bouton5);
    }
}