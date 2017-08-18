import java.io.*;

class sone{
	static int a,b;
	sone(int x,int y){
		a=x;
		b=y;
	}
	static{
		System.out.println("sone's static has been executed");
	}
}

class ustatic extends sone{
	static int a = 10;
	static int b;
	ustatic(int x,int y,int z){
		super(x,y);
		b=z;
	}
	static{
		System.out.println("static block is called");
	}
	public static void main(String ae[]){
		
		ustatic bb= new ustatic(1,2,3);
		b=20;
		System.out.println(sone.a);
		System.out.println("the valle of b is "+b);
		//sone.a=2;
		//System.out.println(sone.a);
	}


}