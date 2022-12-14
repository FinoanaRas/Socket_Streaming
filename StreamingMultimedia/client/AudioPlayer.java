package utilities;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import jaco.mp3.player.MP3Player;
public class AudioPlayer extends MP3Player{
    File toPlay;
    String[] listSongs;
    public void setToPlay(File newValue){
        toPlay = newValue;
    }
    public File getToPlay(){
        return toPlay;
    }
    public void setListSongs(String[] newValue){
        listSongs = newValue;
    }
    public String[] getListSongs(){
        return listSongs;
    }
    public AudioPlayer(String[] list,File playnow){
        super(playnow);
        setToPlay(playnow);
        setListSongs(list);
    }
    public AudioPlayer(String[] list){
        setListSongs(list);
    }
    public void play(){
        
        super.play();
    }
    public void continu(){
        super.play();

    }
    public int getIndiceOnList(){
        for(int i=0;i<getListSongs().length;i++){
            if(getToPlay().getName().equals(getListSongs()[i])==true){
                return i;
            }
        }
        return -1;
    }
    public String previous(){
        if(getIndiceOnList()-1<=0){
            return getListSongs()[getIndiceOnList()];
        }
        return getListSongs()[getIndiceOnList()-1];
    }
    public String next(){
        if(getIndiceOnList()+1>=getListSongs().length){
            return getListSongs()[getIndiceOnList()];
        }
        return getListSongs()[getIndiceOnList()+1];
    }
}