import java.io.*;

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
		if(p.y!=x){return true;}else{return false;}

	}

	public int compareto(Point p){
		double d = find_distance();
		double d1 = p.find_distance();	
		if(d>d1){
			return 1;
		}
		else if(d==d1){return 0;}
		else{return -1;}
	}

}

class compareit implements Comparator{
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
	
	HashSet<Point> pset = new HashSet<Point>(); 
	for(int i = 0;i<n;i++){
		System.out.println("Enter the x co-ordinate");
		int x = s.nextDouble();
		System.out.println("Emter the y co-ordinate");
		int y = s.nextDouble();
		Point p = new Point(x,y);
		pset.add(p);
	}
	
	ArrayList<Point> plist = new ArrayList<Point>(pset);
	plist.sort(new compareit());

	Iterator it1 = plist.iterator();
	while(it1.hasNext()){
		Point p1 = it1.next();
		double d = p1.find_distance(0,0);
		System.out.println("the distance between the origin is"+d);

	
	}
	Iterator it2 = plist.iterator();
	while(itr2.hasNext()){
		int j = itr2.nextIndex();	
		Iterator itr3 = plist.iterator(j);
		while(itr3.hasNext()){
			
			
		}
			
	}
]
}

