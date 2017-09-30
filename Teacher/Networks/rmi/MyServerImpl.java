//definition of MyServerIntf
import java.rmi.*;
import java.rmi.server.*;

public class MyServerImpl extends UnicastRemoteObject implements MyServerIntf
{

	MyServerImpl() throws RemoteException
	{}

	public double add(double a, double b) throws RemoteException
	{
		return(a+b);
	}	
}
