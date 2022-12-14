package graphics;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import threadclient.*;
import java.io.*;
import java.net.*;
import utilities.AudioPlayer;
public class ButtonListener implements MouseListener{
    AudioPlayer mp3;
    ClientThread thread;
    JButton bouton;
    JTable table;
    Socket socket;
    public void set_socket(Socket newValue){
        socket = newValue;
    }
    public Socket get_socket(){
        return socket;
    }
    public void setMp3(AudioPlayer newValue){
        mp3 = newValue;
    }
    public AudioPlayer getMp3(){
        return mp3;
    }
    public void setThread(ClientThread newValue){
        thread = newValue;
    }
    public ClientThread getThread(){
        return thread;
    }
    public void setBouton(JButton newValue){
        bouton = newValue;
    }
    public JButton getBouton(){
        return bouton;
    }
    public void setTable(JTable newValue){
        table = newValue;
    }
    public JTable getTable(){
        return table;
    }
    public ButtonListener(ClientThread ct,JButton b,JTable tab,Socket s){
        setMp3(ct.getPlayer());
        setThread(ct);
        setBouton(b);
        setTable(tab);
        set_socket(s);
    }
    
    public void mouseClicked(MouseEvent e)
    {
        AudioPlayer play = getThread().getPlayer();
        String choix = new String();
        if(getTable().getSelectedRow()==-1){
            choix = play.getListSongs()[0];
        }else{
            choix = play.getListSongs()[getTable().getSelectedRow()];
        }
        switch(getBouton().getText()){
            case "play":
                if(getThread().getPlayer().getPlayList()==null){
                    ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(get_socket().getOutputStream()));
                    oos.writeObject(choix);
                }
                if(getThread().getPlayer().isPaused()){
                    getThread().getPlayer().continu();
                }else{
                    getThread().start();
                }
                break;
            case "pause":
                getThread().getPlayer().pause();
                break;
            case "stop":
                getThread().getPlayer().stop();
                break;
            case "next":
                getThread().getPlayer().skipForward();
                break;
            case "previous":
                getThread().getPlayer().skipBackward();
                break;
        }
    }
    public void mouseEntered(MouseEvent e)
    {

    }
    public void mouseExited(MouseEvent e)
    {
        
    }
    public void mousePressed(MouseEvent e)
    {
        
    }
    public void mouseReleased(MouseEvent e)
    {
        
    }
}