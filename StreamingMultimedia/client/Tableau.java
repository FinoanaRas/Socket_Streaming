package graphics;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import utilities.*;
import java.io.*;
import java.util.*;
import java.net.*;
public class Tableau extends JTable{
    Socket socket;
    AudioPlayer player;
    String[][] donnees;
    public void set_socket(Socket newValue){
        socket = newValue;
    }
    public Socket get_socket(){
        return socket;
    }
    public void setPlayer(AudioPlayer newValue){
        player = newValue;
    }
    public AudioPlayer getPlayer(){
        return player;
    }
    public void setDonnees(String[][] newValue){
        donnees = newValue;
    }
    public String[][] getDonnees(){
        return donnees;
    }
    // @Override
    // raha isPlaying, atao stop, de avy eo soloina
    // maka anle fichier any am serveur
    public Tableau(String[][] data,String[] noms,Socket s,AudioPlayer player){
        super(data,noms);
        set_socket(s);
        setPlayer(player);
        setDonnees(data);
    }
    public void valueChanged(ListSelectionEvent e){
        if(!e.getValueIsAdjusting()&&getSelectedRow()!=-1){
            System.out.println(getDonnees()[e.getFirstIndex()][0]);

        }
    }
}