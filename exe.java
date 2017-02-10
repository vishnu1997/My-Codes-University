import java.io.*;
import java.util.*;

class BadOperandException extends Exception{
	public String toString(){
		return ("error caused Bad operand");
	}
}

class BadOperatorException extends Exception{
	public String toString(){
		return ("error caused Bad operator");
	}
}

class OperationFailedException extends Exception{
	public String toString(){
		return ("Expression evaluation failed");
	}
}

public class exe{
	public static void main(String args[]){
		Scanner s= new Scanner(System.in);
		System.out.println("Enter first operand");
		String s1 = s.nextLine();
		int a = Integer.parseInt(s1);
		System.out.println("Enter second operand");
		String s2 = s.nextLine();
		int b = Integer.parseInt(s2);
		System.out.println("Enter operator");
		char s3 = s.next().charAt(0);
		try{
			if((a>10000)&&(a<50000)&&(b>500)&&(b<5000)){
							
			 	if(!(s3=='+'||s3=='-'||s3=='*'||s3=='/')){
					OperationFailedException f = new OperationFailedException();
					BadOperatorException f1 = new BadOperatorException();
					f.initCause(f1);
					throw f; 
				}
				else{	int g = 0;
					switch(s3){
						case '+':
							g = a+b;
							break;
					
						case '-':
							g = a-b;
							break;
					
						case '*':
							g = a*b;
							break;
					
						case '/':
							g = a/b;
							break;
					}
					System.out.println("the result of the expression is "+g);
				}
			}
			else{
				OperationFailedException e = new OperationFailedException();
				BadOperandException e1 = new BadOperandException();
				e.initCause(e1);
				throw e;
				}  		
		}catch(OperationFailedException d){
			System.out.println(d);
			System.out.println(d.getCause());			
		}			
	}
}