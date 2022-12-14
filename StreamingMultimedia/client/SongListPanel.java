package graphics;
import javax.swing.*;
import java.awt.*;
import utilities.*;
import threadclient.*;
public class SongListPanel extends JPanel{
    public SongListPanel(ClientThread ct){
        display(ct);
    }
    public void display(ClientThread ct){
        String[] liste = ct.getPlayer().getListSongs();
        JList<String> listDisplay = new JList<String>(liste);
        
        listDisplay.setSize(400,this.getHeight());
        add(listDisplay);
    }
}