package fd;

import pkinterface.*;

public class FDAccount extends Account implements InterestRate{
	int period;
	//------------------------------------------constructor
	FDAccount(int accno,double amo,int per){
		super(accno,amo);
		period = per;
		System.out.println("Your FDAccount is created");
	}
	//------------------------------------------calc_interest
	double calc_interest(){
		double d = (balance*period*fdrate)/100;
		return d;
	}
	//-------------------------------------------close
	void close(){
		double d = calc_interest();
		balance = balance + d;
		System.out.println("After closing your amount "+balance);
	}

}
