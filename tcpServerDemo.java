import java.net.*;
import java.io.*;

public class tcpServerDemo {
    public static void main(String ar[]){
        try{
            int port = 4444;
            ServerSocket ss = new ServerSocket(port);
            InetAddress IP=InetAddress.getLocalHost();
            //System.out.println("IP of my system is := "+InetAddress.getLocalHost());
            Socket s = ss.accept();
            /*InetAddress IP=InetAddress.getLocalHost();
            System.out.println("IP of my system is := "+InetAddress.getLocalHost());*/
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeInt(1232);

        }catch(Exception e){
            System.out.println(e);
        }
    }
}