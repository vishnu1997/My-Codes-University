import java.io.*;
import java.net.*;

public class udpServer {
    public static void main(String ar[]){
        try{
            DatagramSocket ds = new DatagramSocket();
            InetAddress ia  = InetAddress.getLocalHost();
            String mes = "message sent and receieved successfully";
            byte b[] = mes.getBytes();
            DatagramPacket dp = new DatagramPacket(b,b.length,ia,4444);
            ds.send(dp);
        }catch(Exception e){
            System.out.println();
        }
    }
}