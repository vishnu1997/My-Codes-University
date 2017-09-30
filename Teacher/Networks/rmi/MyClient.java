import java.net.*;
import java.rmi.*;

public class MyClient
{
	public static void main(String[] arg)
	{
		try 	
		{
			String sName = "rmi://"+arg[0]+"/MyS";

			MyServerIntf asif = (MyServerIntf)Naming.lookup(sName);
			
			double d1=20,d2=40;

			System.out.println("Addition: "+asif.add(d1,d2));

		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
	}
}
