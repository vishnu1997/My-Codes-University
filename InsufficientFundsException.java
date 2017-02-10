package pkbanking.pkexception;

public class InsufficientFundsException extends Exception{
	String description;
	
	InsufficientFundsException(){
		description = "Insufficient Funds ";
	}

	InsufficientFundsException(String e){
	description = e;
	}
	
	public String toString(){
		return description;
	} 

}