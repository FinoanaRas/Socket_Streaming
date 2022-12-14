package graphics;
import javax.swing.*;
import java.awt.*;
import utilities.*;
import java.io.*;
import java.util.*;
import java.net.*;
import threadclient.ClientThread;
public class SongPanel extends JPanel{
    public SongPanel(String[] list,Socket s){
        display(list,s);
    }
    public void display(String[] list,Socket s){
        AudioPlayer mp3 = new AudioPlayer(list);
        ClientThread ct = new ClientThread(mp3);
        JPanel p =  new JPanel();
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        JLabel[] liste = new JLabel[list.length];
        for(int i=0;i<list.length;i++){
            liste[i] = new JLabel();
            liste[i].setText(mp3.getListSongs()[i]);
            liste[i].setOpaque(true);
            liste[i].setBounds(10,i*20,100,10);
            liste[i].setBackground(new Color(171,204,221,255)); 
            liste[i].addMouseListener(new PickListener(ct,liste[i],s,"music.mp3"));   
            p.add(liste[i]);
        }
        p.setSize(300,400);
        add(p);
        
        // String[][] tab = new String[list.length][1];
        // for(int i=0;i<list.length;i++){
        //     tab[i][0] = list[i];    
        // }
        // String[] nom = new String[1];
        // nom[0] = "liste";
        // AudioPlayer player = new AudioPlayer(list);
        // Tableau tableau = new Tableau(tab,nom,s,player);
        // tableau.setTableHeader(null);
        // JScrollPane scrollpane = new JScrollPane(tableau);
        // tableau.setSize(400,200);
        // scrollpane.setSize(400,0);
        // tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // add(tableau.getTableHeader(),BorderLayout.NORTH);
        // add(scrollpane,BorderLayout.SOUTH);
        JButton bouton = new JButton("play");
        bouton.setBounds(0,0,50,50);
        bouton.addMouseListener(new MusicListener(s,ct,bouton));
        add(bouton);
        JButton bouton2 = new JButton("pause");
        bouton2.setBounds(50,0,50,50);
        bouton2.addMouseListener(new MusicListener(s,ct,bouton2));
        add(bouton2);
        JButton bouton3 = new JButton("stop");
        bouton3.setBounds(100,0,50,50);
        bouton3.addMouseListener(new MusicListener(s,ct,bouton3));
        add(bouton3);
        // JButton bouton4 = new JButton("previous");
        // bouton4.setBounds(150,0,50,50);
        // bouton4.addMouseListener(new MusicListener(s,ct,bouton4));
        // add(bouton4);
        // JButton bouton5 = new JButton("next");
        // bouton5.setBounds(200,0,50,50);
        // bouton5.addMouseListener(new MusicListener(s,ct,bouton5));
        // add(bouton5);
        // setSize(10,10);
    }
}