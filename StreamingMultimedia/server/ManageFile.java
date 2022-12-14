package utilities;
import java.io.*;
import java.util.*;
public class ManageFile{
    public static String[] getTitles(File[] list){
        String[] titres = new String[list.length];
        for(int i=0;i<list.length;i++){
            titres[i] = list[i].getName();
        }
        return titres;
    }
    public static void tri(String[] list,String[] music,String[] video,String[] image){
        ArrayList<String> musicList = new ArrayList<String>();
        ArrayList<String> videoList = new ArrayList<String>();
        ArrayList<String> imageList = new ArrayList<String>();
        for(int i=0;i<list.length;i++){
            if(list[i].endsWith("mp3")){
                musicList.add(list[i]);
            }else if(list[i].endsWith("mp4")){
                videoList.add(list[i]);
            }else if(list[i].endsWith("jpg")||list[i].endsWith("png")){
                imageList.add(list[i]);
            }
        }
        music = musicList.toArray(music);
        video = videoList.toArray(video);
        image = imageList.toArray(image);
    }
}