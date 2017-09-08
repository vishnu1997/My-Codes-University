import java.net.*;
import java.io.*;
import java.util.*;

public class client{
	public static void main(String args[]){
	try{

		
		Socket soc = new Socket("172.22.10.52",5000);
		DataOutputStream dout = new DataOutputStream(soc.getOutputStream());
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
		System.out.println("Message Encrypted");
		System.out.println(str1);
		dout.writeUTF(str1+" "+key);
		System.out.println("Message sent");
		}
		
		catch(Exception e){
			System.out.println("Exception"+e);
		}

	}
}
