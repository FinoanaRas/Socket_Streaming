package graphics;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import threadclient.*;
import socket.ClientSocket;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import utilities.AudioPlayer;
public class MusicListener implements MouseListener{
    AudioPlayer mp3;
    ClientThread thread;
    JButton bouton;
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
    public MusicListener(Socket s,ClientThread ct,JButton b){
        setMp3(ct.getPlayer());
        setThread(ct);
        setBouton(b);
        set_socket(s);
    }
    public void playProcess(String choix)throws Exception{
        // ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(get_socket().getOutputStream()));
        ClientSocket socket = (ClientSocket) get_socket(); 
        ObjectOutputStream oos = socket.get_out() ;
        oos.writeObject(choix);
        oos.flush();
        // ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(get_socket().getInputStream()));
        ObjectInputStream in = socket.get_in();
        byte[] bitFichier = (byte[]) in.readObject();
        Files.deleteIfExists(Paths.get("./assets/music.mp3"));
        File f = new File(Files.createFile(Paths.get("./assets/music.mp3")).toString());
        f.deleteOnExit();
        Files.write(f.toPath(),bitFichier);
        // oos.close();       
    }
    public void change(String choix){
        if(getThread().getPlayer().isStopped()==false){
            getThread().getPlayer().stop();
        }
        try{
            playProcess(choix);
            File f = new File("./assets/music.mp3");
            getThread().getPlayer().setToPlay(f);
            getThread().getPlayer().addToPlayList(f);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void mouseClicked(MouseEvent e)
    {
        switch(getBouton().getText()){
            case "play":
                if(getThread().getPlayer().isPaused()||getThread().getPlayer().isStopped()){
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
                change(getThread().getPlayer().next());
                break;
            case "previous":
                change(getThread().getPlayer().previous());
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