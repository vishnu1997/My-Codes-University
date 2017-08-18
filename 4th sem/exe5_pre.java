import java.io.*;


//------------------------------------Factorial
class Factorial extends Thread{
	int f;
	Factorial(int f){
		this.f = f;
		start();
	}

	public void run(){
		int fact = 1;
		for(int i=1;i<=f;i++){
			fact *= i;
			if(i == 5)
			try{sleep(300);}catch(InterruptedException e){}
		}
		sop("factoial answer is "+fact);	
	}

}

//------------------------------------Sum Of Series
class SumOfSeries extends Thread{
	int n,sum;
	SumOfSeries(int a){
		n = a;
		sum = 0;
		start();
	}


	public void run(){
		for(int i=0;i<=n;i++){
			sum +=i;
			if(i==7)
			suspend();
		}
			
	}


}

//------------------------------------Multipliccation table
class MultiplicationTable extends Thread{
	int m;
	MultiplicationTable(int b){
		m = b;
		start();
	}

	public void run(){
		for(int i=0;i<=10;i++){
			S
		}		
			
	}

}

//------------------------------------Main method

class exe5_pre{
	public static void main(String az[]){
				

		
		sop("Main loop exited");
	}
	

}