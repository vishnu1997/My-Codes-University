import java.io.*;
import java.util.*;

//--------------------------------------------Account class
class Account{
	int accnumber;
	double balance;
	//------------------------------------------constructor
	Account(int a,double b){
		accnumber = a;
		balance = b;
	}
}
//--------------------------------------------SBAccount class

class SBAccount extends Account{
	//------------------------------------------constructor
	SBAccount(int a,double b){
		super(a,b);
		System.out.println("your SBAccount is created");
	}
	//-----------------------------------------deposit
	void deposit(double a){
		balance += a;
		System.out.println("your balance is"+balance);
	}
	//-----------------------------------------withdraw
	void withdraw(double a){
		balance -= a;
		if(balance>1000){
			System.out.println("your balAnce after withdraw is"+balance);
		}
		else{
			balance += a;
			System.out.println("sorry less amount");
		}
	}
	//------------------------------------------interest
	void calc_interest(){
		double rate = 4;
		double d = (balance * 1 * rate)/100;
		balance += d;
		System.out.println("Your balance amount after adding interest is "+balance);
	}
}

//----------------------------------------------FDAccount class
class FDAccount extends Account{
	int period;
	//------------------------------------------constructor
	FDAccount(int accno,double amo,int per){
		super(accno,amo);
		period = per;
		System.out.println("Your FDAccount is created");
	}
	//------------------------------------------calc_interest
	double calc_interest(){
		double rate = 8.25;
		double d = (balance*period*rate)/100;
		return d;
	}
	//-------------------------------------------close
	void close(){
		double d = calc_interest();
		balance = balance + d;
		System.out.println("After closing your amount "+balance);
	}

}

//-----------------------------------------------Customer
class Customer{
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
	void createAccount(int type){
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
	void transaction(int type){
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

//------------------------------------------------BankDemo
class BankDemo{
	public static void main(String arg[]){
		Customer c[] = new Customer[5];
		int choice,id,d;
		Scanner s = new Scanner(System.in);
		String name,address,r;
		String b = "y";
		for(int i=0;i<5;i++){
			System.out.println("enter you name");
			name = s.nextLine();
			System.out.println("enter your address");
			address = s.nextLine();
			System.out.println("enter your id");
			r = s.nextLine();
			id = Integer.parseInt(r);
			c[i] = new Customer(id,name,address);
			System.out.println("for SB Account 	type 1 for FD account type 2");
			String q = s.nextLine();
			int type = Integer.parseInt(q);
			c[i].createAccount(type);
			if(type==1){
				while(b.equals("y")){
					System.out.println("1 for deposit 2.for withdraw 3.for interest.5 for exit");
					String w = s.nextLine();
					choice = Integer.parseInt(w);
					c[i].transaction(choice);
					System.out.println("if u want to continue press y or else press n");
				  b = s.nextLine();
					if(b.equals("n")){
						break;
					}
				}
			}
			else{
				System.out.println("Do you want to close your account");
			  b = s.nextLine();

				if(b.equals("y")){
					c[i].transaction(4);
				}
			}
		}
	}
}
