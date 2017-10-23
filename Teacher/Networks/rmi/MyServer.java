import java.net.*;
import java.rmi.*;

public class MyServer
{
	public static void main(String[] arg)
	{
		try 	
		{
			MyServerImpl asi = new MyServerImpl();
			Naming.rebind("MyS",asi);
			System.out.println("\nServer Started...");
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
	}
}
