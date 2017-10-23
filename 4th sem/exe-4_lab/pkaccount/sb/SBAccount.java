package pkaccount.sb;

import pkbanking.pkexception.InsufficientFundsException;
import pkbanking.pkinterface.*;
import pkaccount.*;

public class SBAccount extends Account implements Transaction,InterestRate{
	//------------------------------------------constructor
	public SBAccount(int number,double init_balance){
		super(number,init_balance);
		System.out.println("your SBAccount is created");
	}
	//-----------------------------------------deposit
	public void deposit(double a) throws IllegalArgumentException{
    	if(a>0){
			if(balance>0)
				balance += a;	
			}
		else{
			throw new IllegalArgumentException("Can't deposit'");
		}	
	}
	//-----------------------------------------withdraw
	public void withdraw(double a) throws InsufficientFundsException{
		balance -= a;
		if(balance>min_balance){
			System.out.println("your balAnce after withdraw is"+balance);
		}
		else{
			balance += a;
			throw new InsufficientFundsException("can't withdraw'");
		}
	}
	//------------------------------------------interest
	public void calc_interest(){
		double d = (balance * 1 * sbrate)/100;
		balance += d;
		System.out.println("Your balance amount after adding interest is "+balance);
	}
}
