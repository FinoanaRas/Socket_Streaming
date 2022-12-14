import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import socket.ClientSocket;
import graphics.FrameDisplay;
import jaco.mp3.player.MP3Player;
import utilities.AudioPlayer;
import threadclient.ClientThread;
public class MyClient{
    public static void main(String[] args){
        try{
            // Socket s = new Socket("localhost",3571);
            ClientSocket s = new ClientSocket("localhost",3571);
            // DataOutputStream output = new DataOutputStream(s.getOutputStream());
            // ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(s.getInputStream()));
            String[] liste = (String[]) s.get_in().readObject();
            // for(int i=0;i<liste.length;i++){

            // System.out.println(liste[i]);
            // }
            FrameDisplay frame = new FrameDisplay(liste,s);
            // ClientThread ct = new ClientThread(mp3);
            // DisplayFrame frame = new DisplayFrame(ct);
            // output.close();
            
            // s.close();
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}