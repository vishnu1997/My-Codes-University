import java.net.*;
import java.io.*;
import java.util.*;

public class client{
public static void main(String args[]){
try{

	
	DatagramSocket soc = new DatagramSocket(3000);
	System.out.println("Connection Established");
	System.out.println("Enter the key for encryption");
	Scanner din = new Scanner(System.in);
	int key = din.nextInt();
	System.out.println("Enter the message to be transmitted");
	din = new Scanner(System.in);
	String str = din.nextLine();
	
	int i;
	String str1="";
	for (i=0;i<str.length();i++){
		int c=str.charAt(i)+key;
		str1 += (char)c;
	}
	str1 = str1 + " " + key;
	System.out.println("Message Encrypted");
	System.out.println(str1);
	byte[] message = str1.getBytes();
	DatagramPacket p = new DatagramPacket(message, message.length, InetAddress.getByName("localhost"), 5000);
	soc.send(p);
	System.out.println("Message sent");
	}
	
	catch(Exception e){
		System.out.println("Exception"+e);
		}

}
}
