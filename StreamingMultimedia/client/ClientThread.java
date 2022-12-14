package threadclient;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.lang.Thread;
import utilities.AudioPlayer;
import jaco.mp3.player.MP3Player;
public class ClientThread extends Thread{
    AudioPlayer player;
    public void setPlayer(AudioPlayer newValue){
        player = newValue;
    }
    public AudioPlayer getPlayer(){
        return player;
    }
    public ClientThread(AudioPlayer newPlayer){
        setPlayer(newPlayer);
    }
    public ClientThread(){}
    public void run(){
        AudioPlayer mp3 = getPlayer();
        try{
            mp3.play();
            while(!mp3.isStopped()){
                this.sleep(5000);
            }   
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
}