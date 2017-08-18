import java.net.*;
import java.io.*;

public class tcpClientDemo {
    public static void main(String ar[]){
        try{
            int c;
        String server = "172.22.10.52";
        Socket s = new Socket(server,4444);
        InputStream is = s.getInputStream();
       // DataInputStream dis  = new DataInputStream(is);
        //int i = dis.readInt();
        //System.out.println(i);
        while ((c = is.read()) != -1) {
            System.out.print((char) c); }
        s.close();}catch(Exception e){System.out.println(e);}
    }
}