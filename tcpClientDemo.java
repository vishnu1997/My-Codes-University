import java.net.*;
import java.io.*;

public class tcpClientDemo {
    public static void main(String ar[]){
        try{
        String server = "localhost";
        Socket s = new Socket(server,4444);
        InputStream is = s.getInputStream();
        DataInputStream dis  = new DataInputStream(is);
        int i = dis.readInt();
        System.out.println(i);
        s.close();}catch(Exception e){System.out.println(e);}
    }
}