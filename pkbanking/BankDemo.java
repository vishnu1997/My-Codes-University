package pkbanking;

import java.io.*;
import java.util.*;
import pkcustomer.*;

public class BankDemo{
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
