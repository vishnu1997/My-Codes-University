import java.io.*;



//-------------------------------------------queue
class queue{
<<<<<<< HEAD
//	int arr[10],front,rear;
=======
	int arr[]=new int[10];
	int front,rear;
>>>>>>> 3e6863af30668d4c9a297c9ecbff2a680e02983b
	boolean full,empty;

	queue(){
<<<<<<< HEAD
	//	arr[]=0;
=======
		
>>>>>>> 3e6863af30668d4c9a297c9ecbff2a680e02983b
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
<<<<<<< HEAD

			notifyAll();
			arr[front] = i;


	}

	synchronized void get(){

		if(rear>-1){
			wait();
		}


	}


}

class producer {

	//queue q

=======
		
			
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
>>>>>>> 3e6863af30668d4c9a297c9ecbff2a680e02983b

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
<<<<<<< HEAD
    public static void main(){}
}
=======
	public static void main(String arg[]){
		queue q = new queue();
		producer p = new producer(q);
		customer c = new customer(q);
	}
}
>>>>>>> 3e6863af30668d4c9a297c9ecbff2a680e02983b
