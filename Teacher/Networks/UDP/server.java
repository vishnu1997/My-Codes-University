import java.net.*;
import java.io.*;

public class server{
public static void main(String args[]){
try{

	
	DatagramSocket soc = new DatagramSocket(5000);
	byte[] b = new byte[30];
	int key =0;
	String key1 = "";
	DatagramPacket p = new DatagramPacket(b, b.length);
	soc.receive(p);
	System.out.println("Connection established");
	String str1 = new String(p.getData());
	System.out.println("Received Encrypted Message  :   " + str1);
	String[] df = str1.split(" ");
	
	for (String i:df){
				key1=i;
			}
	key1=key1.trim();
	key = Integer.parseInt(key1);
				
				
	if (key==0){
	System.out.println("Message not decrypted correctly");
	}
	String str="";
	String str2="";
	
	for (int i=0; i<=df.length-2; i++){
		str = str+ df[i];
		}
	System.out.println("Received Message  :   " + str);	
	for (int i=0;i<str.length();i++){
		int c=str.charAt(i)-key;
		str2 += (char)c;
	}
	System.out.println("Message decrypted");
	System.out.println(str2);
	}
	catch(Exception e){
		System.out.println("Exception"+e);
		}

}
}



