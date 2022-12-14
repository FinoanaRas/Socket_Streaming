package graphics;
import javax.swing.*;
import java.awt.*;
import utilities.*;
import threadclient.*;
public class DisplayFrame extends JFrame{
    AudioPlayer mp3;
    public void setMp3(AudioPlayer newValue){
        mp3 = newValue;
    }
    public AudioPlayer getMp3(){
        return mp3;
    }
    public DisplayFrame(ClientThread ct){
        setMp3(ct.getPlayer());
        display(ct);
        setSize(500,600);
        setTitle("Mp3Player");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public void display(ClientThread ct){
        SongListPanel liste = new SongListPanel(ct);
        liste.setBounds(0,0,200,400);
        liste.setBackground(new Color(204,140,102,255));
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(liste);
        ControlPanel panel = new ControlPanel(ct);
        panel.setBounds(0,400,500,600);
        panel.setBackground(new Color(204,40,102,255));
        add(panel);
        add(scroll);
        add(new JPanel());
    }
}