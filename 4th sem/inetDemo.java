import java.net.*;
import java.io.*;

public class inetDemo {
    public static void main(String ar[]){
        try{
        InetAddress localHost  = InetAddress.getLocalHost();
        //InetAddress localHostAddress 
        String s= InetAddress.getLocalHost().getHostAddress();
        InetAddress addressByName = InetAddress.getByName("www.sastra.edu");
        InetAddress allAddress[]  = InetAddress.getAllByName("www.sastra.edu");
        System.out.println("ALl the possible links linked with a website");
        for (int i=0; i<allAddress.length; i++)
            System.out.println(allAddress[i]);

        System.out.println("local host details"+localHost);
        
        System.out.println("local host Address"+s);
        
        System.out.println("address by name"+addressByName);}catch(Exception e){}
    }
}