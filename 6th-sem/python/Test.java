import java.io.*;
import java.util.*;


public class Test implements Runnable{
	public void run()
	{
    System.out.println("r1 ");
    System.out.println("r2 ");
	}
	
	public static void main(String ar[]){
		Thread t = new Thread(new Test());
		t.start();
        // System.out.print("m1 ");
        System.out.println("m1 ");
        try{
		t.join();}catch(Exception e){}
		System.out.print("m2 ");
	}

}
