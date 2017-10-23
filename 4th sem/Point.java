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

//-------------------------------------------Main method
public static void main(String ar[]){
   Point p1 = new Point(3.25,7.89);
   Point p2 = new Point(5.37,18.12);
   Point p3 = new Point(p2);
    double d;
    d = p1.find_distance(7.9,16.25);
    System.out.println("first distance is"+d);
     d = p1.find_distance(p3);
     System.out.println("second distance is"+d);
     p3.display();
}
};
