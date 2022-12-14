package utilities;
import java.io.*;
public class AudioFileFilter implements FilenameFilter{
    public boolean accept(File dir,String name){
        if(name.endsWith("mp3")){
            return true;
        }
        return  false;
    }
}