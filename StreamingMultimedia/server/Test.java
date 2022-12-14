import javax.swing.*;
import java.io.*;
import java.net.*;
import jaco.mp3.player.MP3Player;
public class Test{
    public static void main(String[] args){
        try{
            File file = new File("assets/music/AMBONDRONA_ajanony.mp3");
            // File file = new File("C:/short/aiaiai_im_ur_little_butterfly(128k).mp3");
            File file2 = new File(file.toURI());
            MP3Player mp3 = new MP3Player(file2);
            // mp3.setRepeat(true);
            // mp3.play();
            // while(!mp3.isStopped()){
            //     Thread.sleep(5000);
            // }
            System.out.println(file.getName().split("m")[0]);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}