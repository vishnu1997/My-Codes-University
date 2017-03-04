import java.io.*;
import java.util.*;

class Point1{
   double x,y;
//-----------------------------------Default construtor
   Point1(){
     x = 0;
     y = 0;
   }
//----------------------------------Parameterized constructor
   Point1(double q,double p){
      x = q;
      y = p;
   }
//--------------------Parameterized constructor with object as parameter
   Point1(Point1 ob){
    x = ob.x;
    y = ob.y;
   }
//-----------------------------Find distance with x,y parameters
   double find_distance(double a,double b){

          double d = Math.sqrt(((a-x)*(a-x))+((b-y)*(b-y)));
           return d;
    }

//---------------------------------Find distance with Point1 object
   double find_distance(Point1 p){
         double d = Math.sqrt(((p.x)-x)*((p.x)-x)+((p.y)-y)*((p.y)-y));
           return d;
   }

//------------------------------------------Display
   void display(){
         System.out.println("("+x+","+y+")");
   }

//-------------------------------------------Main method
	public static void main(String ar[]){
		Scanner s = new Scanner(System.in);
	
		ArrayList<Point1> plist = new ArrayList<Point1>();
		System.out.println("Enter the no of elments");
		int n = s.nextInt();
	
		for(int i=0;i<n;i++){
			System.out.println("enter the x  cordinate");
			double x = s.nextDouble();
			System.out.println("enter the y cordinate");
			double y = s.nextDouble();	
			Point1 p = new Point1(x,y);
			plist.add(p); 	
		}
  		
		for(int i = 0;i<n-1;i++){
			for(int j = i+1;j<n;j++){
				Point1 p1 = plist.get(i);
				Point1 p2 = plist.get(j);
				double d = p1.find_distance(p2);
				p1.display();
				p2.display();
				System.out.println("The distance between the two Point1s are "+d);
				
			}		
	
		}
	}
};
