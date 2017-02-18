import java.io.*;



//-------------------------------------------queue
class queue{
	int arr[]=new int[10];
	int front,rear;
	boolean full,empty;
		
	queue(){
		
		rear = -1;
		front = -1;
		full = false;
		empty = true;

	} 
	
	synchronized void put(int i){
		front++;
		if(front>10){	
				try{
				wait();
			}catch(InterruptedException e){
				
			}	
			
		}
		
			
			arr[front] = i;
			System.out.println("put "+i);
			notify();	
	}

	synchronized void get(){
		
		if(rear<0){
			try{
				wait();
			}catch(InterruptedException e){
				
			}	
								
		}
		int i = arr[rear];
		System.out.println("got "+ i);
		notify();		
	}		
	

}

//-------------------------------------------producer
class producer implements Runnable
{
	Thread t;
	queue q;
	producer(queue q){
		this.q=q;
		t = new Thread(this,"producer");
		System.out.println("producer thread created");
		t.start();	
	}
		
	public void run(){
		for(int i=0;i<10;i++){
			q.put(i);
		}
		
		
	}

}

//-------------------------------------------customer
class customer implements Runnable
{	Thread r;
	queue q;
	customer(queue q){
		this.q=q;
		r = new Thread(this,"customer");	
		System.out.println("customer class created");
		r.start();
	}

	public void run(){
		for(int i=0;i<10;i++){
			q.get();
		}
	
	}

}

//-------------------------------------------main
public class exe5{
	public static void main(String arg[]){
		queue q = new queue();
		producer p = new producer(q);
		customer c = new customer(q);
	}
}