import java.net.*;
import java.io.*;

public class server
 {
public static void main(String args[])
    { 
      try
	{

	ServerSocket s = new ServerSocket(5000);
	Socket soc = s.accept();
	DataInputStream din = new DataInputStream(soc.getInputStream());
	System.out.println("Connection established");
	String str1 = din.readUTF();
	String[] df = str1.split(" ");
	int key = Integer.parseInt(df[df.length-1]);
	String str="";
	String str2="";
	System.out.println(df.length);
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



