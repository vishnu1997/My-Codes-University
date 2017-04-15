import java.io.*;
import java.net.*;

public class udpClient{
    public static void main(String ar[]){
        try{
            int port = 4444;
            DatagramSocket ds = new DatagramSocket(port);
            byte buffer[] = new byte[20];
            DatagramPacket dp = new DatagramPacket(buffer,buffer.length);
            ds.receive(dp);
            String  sh = new String(dp.getData());
            System.out.println("data is"+sh);
            ds.close();
        }catch(Exception e){
            System.out.println(e);}
    }
}