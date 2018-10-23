import java.io.*;
import java.util.*;
import java.lang.*;

class Point{
    int x,y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    void setX(int t){
        this.x = t;
    }
    public boolean equals(Point p) {
        System.out.println("---");
        if(p.x==this.x&&p.y==this.y){
            return true;
        }
        return false;
    }
    public String toString(){
        return " "+x+" "+y;
    }

    
}


public class coastGuard{

    public static void main(String args[]){
        System.out.println("");
        HashMap<Point,Integer> hm = new HashMap<Point,Integer>();
        Point p1 = new Point(2,3);
        Point p2 = p1;
        p2.setX(6);
        Point p3 = new Point(2,3);
        hm.put(p1,1);
        hm.put(p2,4);
        hm.put(p3,3);
        for(Map.Entry<Point,Integer> ea:hm.entrySet()){
            System.out.println("--"+ea.getKey());
            System.out.println(""+(int)ea.getValue());
        }
    }

}