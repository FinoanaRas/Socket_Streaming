package graphics;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.net.*;
import socket.ClientSocket;
public class FenetreListener implements WindowListener{
    Socket socket;
    public void set_socket(Socket newValue){
        socket = newValue;
    }
    public Socket get_socket(){
        return socket;
    }
    public FenetreListener(Socket s){
        set_socket(s);
    }

    
    public void windowClosed(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        try{
            ClientSocket s = (ClientSocket) get_socket();
            s.get_out().writeObject("stop");
            s.get_out().flush();
            s.close();
            System.exit(0);

        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    public void windowOpened(WindowEvent e) {
        
    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {
        
    }

    public void windowActivated(WindowEvent e) {

    }

    public void windowDeactivated(WindowEvent e) {
        
    }
}