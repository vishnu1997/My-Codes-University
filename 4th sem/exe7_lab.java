import java.io.*;
import java.util.*;



class Point{
   double x,y;
//-----------------------------------Default construtor
   Point(){
     x = 0;
     y = 0;
   }
//----------------------------------Parameterized constructor
   Point(double q,double p){
      x = q;
      y = p;
   }
//--------------------Parameterized constructor with object as parameter
   Point(Point ob){
    x = ob.x;
    y = ob.y;
   }
//-----------------------------Find distance with x,y parameters
   double find_distance(double a,double b){

          double d = Math.sqrt(((a-x)*(a-x))+((b-y)*(b-y)));
           return d;
    }

//---------------------------------Find distance with Point object
   double find_distance(Point p){
         double d = Math.sqrt(((p.x)-x)*((p.x)-x)+((p.y)-y)*((p.y)-y));
           return d;
   }

//------------------------------------------Display
   void display(){
         System.out.println("("+x+","+y+")");
   }
	
	public int HashCode(){
		return (int)(x+y);
	}
	
	public boolean equals(Point p){
		if(p.y!=x&&p.x!=y){return true;}else{return false;}

	}

	public int compareto(Point p){
		double d = find_distance(0,0);
		double d1 = p.find_distance(0,0);	
		if(d>d1){
			return 1;
		}
		else if(d==d1){return 0;}
		else{return -1;}
	}

	public String toString()
 { return "("+x+","+y+")"; }

}

class compareit implements Comparator<Point>{
	public int compare(Point p1,Point p2){
		return p1.compareto(p2);
	}

}

public class exe7_lab {
//-------------------------------------------Main method
public static void main(String ar[]){
	Scanner s = new Scanner(System.in);
	
	System.out.println("Enter the no. of elements");
	int n = s.nextInt();
	// hash set initialization
	HashSet<Point> pset = new HashSet<Point>(); 
	for(int i = 0;i<n;i++){
		System.out.println("enter point "+(i+1)+" : ");
		System.out.println("Enter the x co-ordinate");
		double x = s.nextDouble();
		System.out.println("Emter the y co-ordinate");
		double y = s.nextDouble();
		Point p = new Point(x,y);
		pset.add(p);
	}

	System.out.println("Points in hash set");
  System.out.println(pset);

	//Array list initialization
	ArrayList<Point> plist = new ArrayList<Point>(pset);
	
  System.out.println("points in array list after sorting");
	plist.sort(new compareit());
	
	System.out.println(plist);
	ListIterator<Point> it1 = plist.listIterator();
	while(it1.hasNext()){
		Point p1 = (Point)it1.next();
		double d = p1.find_distance(0,0);
		System.out.println("the distance between the origin is"+d);	
	}

	ListIterator<Point> it2 = plist.listIterator();
	while(it2.hasNext()){
		Point p3 = (Point)it2.next();
		int j = it2.nextIndex();	
		ListIterator<Point> it3 = plist.listIterator(j);
		while(it3.hasNext()){
			Point p4 = (Point)it3.next();
			double r = p3.find_distance(p4);
			System.out.println("The distance between points is"+r);
		}		
	}
}
}

