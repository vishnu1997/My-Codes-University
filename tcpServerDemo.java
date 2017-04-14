import java.net.*;
import java.io.*;

public class tcpServerDemo {
    public static void main(String ar[]){
        try{
            int port = 4444;
            ServerSocket ss = new ServerSocket(port);
            Socket s = ss.accept();
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeInt(12321);

        }catch(Exception e){
            System.out.println(e);
        }
    }
}