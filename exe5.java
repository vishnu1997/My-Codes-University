import java.io.*;

class queue{
	int arr[10],front,rear;
	boolean full,empty;
		
	queue(){
		arr[]=0;
		rear = -1;
		front = -1;
		full = false;
		empty = true;

	} 
	
	synchronized void put(int i){
		front++;
		if(front>10){
			wait();
		}
		
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

	queue q


}

class customer
{
	queue q;
}
public class exe5{
    public static void main(){}
}