package utilities;
import java.io.*;
public class ObjectStreamOut extends ObjectOutputStream{
    public ObjectStreamOut(OutputStream out)throws Exception{
        super(out);
    }
    @Override
    protected void writeStreamHeader(){}
}