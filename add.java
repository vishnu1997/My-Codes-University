import java.io.*;

class add{
	int x,y;
	add(int x,int y){
		x=x;
		y=y;
	}
	void display(){
		System.out.println(x);
		int c = x+y;
		System.out.println(c);
	}

	public static void main(String a[]){
		int x;
		System.out.println(x);
		add ob = new add(5,5);
		ob.display();
	} 
};