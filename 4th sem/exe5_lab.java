import java.io.*;



//-------------------------------------------queue
class queue{
//	int arr[10],front,rear;

	int arr[]=new int[10];
	int front,rear;
	boolean full,empty;

	queue(){
	//	arr[]=0;
		rear = -1;
		front = -1;
		full = false;
		empty = true;

	}

	synchronized void put(int i){
		
		if(front>=9){	
					try{
					wait();
				}catch(InterruptedException e){
			}		
		}
		front++;
			notifyAll();
			arr[front] = i;
			System.out.println(arr[front]);
			
	}

	synchronized void get(){

		if(rear<0){
			try{
					wait();
				}catch(InterruptedException e){
			}		
		}
		System.out.println(arr[rear]);
		rear--;
		notifyAll();
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
		for(int i=0;i<15;i++){
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
public class exe5_lab{
	public static void main(String arg[]){
		queue q = new queue();
		producer p = new producer(q);
		customer c = new customer(q);
	}
}
