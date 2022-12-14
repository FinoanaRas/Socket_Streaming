package graphics;
import javax.swing.*;
import java.awt.*;
import utilities.*;
import java.io.*;
import java.util.*;
import java.net.*;
import threadclient.ClientThread;
public class FrameDisplay extends JFrame{
    
    public FrameDisplay(String[] liste,Socket s){
        display(liste,s);
        setSize(800,500);
        setTitle("Mp3Player");
        setVisible(true);
        setLocationRelativeTo(null);
        addWindowListener(new FenetreListener(s));
    }
    public void display(String[] liste,Socket s){
        getContentPane().setLayout(new GridLayout(1,1));
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        
        ArrayList<String> music = new ArrayList<String>();
        ArrayList<String> video = new ArrayList<String>();
        ArrayList<String> image = new ArrayList<String>();
        ManageFile.tri(liste,music,video,image);
        tabbedPane.addTab("musique", new SongPanel(music.toArray(liste),s));
        tabbedPane.addTab("videos", new JPanel());
        tabbedPane.addTab("images", new JPanel());
 
        this.getContentPane().add(tabbedPane);
    }
}