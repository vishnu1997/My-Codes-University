package pkcustomer;

//import pkaccount.sb.*;
import pkaccount.fd.*;
import pkaccount.sb.*;
import pkaccount.*;

public class Customer{
	int cust_id;
	String name,address;
	SBAccount  ob1;
	FDAccount  ob2;
	//-------------------------------------------constructor
	Customer(int id,String n,String ad){
		cust_id = id;
		name = n;
		address = ad;
	}
	//--------------------------------------------createAccount
	public void createAccount(int type){
		int acc,choice,per;
		double d,dep,wit;
		Scanner s = new Scanner(System.in);
		System.out.println("enter accountnumber");
		acc = s.nextInt();
		System.out.println("enter balance you want to deposit");
		d = s.nextDouble();
		if(type == 1){
			ob1 = new SBAccount(acc,d);
		}
		else{
			System.out.println("Enter the period for which you want to deposit");
			per = s.nextInt();
			ob2 = new FDAccount(acc,d,per);
		}
	}
	//--------------------------------------------transaction
	public void transaction(int type){
		double dep,wit;
		Scanner s = new Scanner(System.in);
		switch(type){
			case 1:
				System.out.println("Enter the amount you want to deposit");
				dep = s.nextDouble();
				ob1.deposit(dep);
				break;
			case 2:
				System.out.println("Enter the amount you want to withdraw");
				wit = s.nextDouble();
				ob1.withdraw(wit);
				break;
			case 3:
				ob1.calc_interest();
				break;
			case 4:
				ob2.close();
				break;
		}

	}
}
