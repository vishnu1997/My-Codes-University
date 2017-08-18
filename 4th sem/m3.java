import java.io.*;

class m1{
  void display(){
    System.out.println("base");
  }

}
class m2 extends m1{
  void display(){
    System.out.println("derived");
  }

}

class m3{
  public static void main(String args[]){
    m1 ob = new m1();
    ob.display();
    ob=new m2();
    ob.display();
  }
}
