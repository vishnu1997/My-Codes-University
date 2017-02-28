import java.io.*;

class Sync{

    synchronized static void call(String mes){
      System.out.println("Synchronize me with "+mes);
      try{
        Thread.sleep(1000);
        System.out.println("....");
      }catch(Exception e){}
    }
}

class extendsThread extends Thread{
  String name;
  extendsThread(String name){
    super(name);
    this.name  = name;
    System.out.println("Thread extended" + name);
    start();
  }
  public void run(){
    try{
      for(int i=0;i<3;i++){
      //  System.out.println("extended child thread: "+i+"   "+this);
        Sync.call(name);
        sleep(300);
      }
    }catch(InterruptedException e){
      System.out.println("Exception caught in extended class");
    }
  }
}

class implementThread implements Runnable{
  Thread r;
  static int e = 0;
  implementThread(){
    e++;
    System.out.println("implemnted thread created");
    // new Thread(this,"implemented Thread").start(); this one can be used when no thread object r is declared inside the class
    r = new Thread(this,"implemented Thread");
    r.start();
  }
  public void run(){
    try{
      for(int i=0;i<3;i++){
        //System.out.println("implemented child thread: "+i+"  "+this);
        //Sync.call("Inside implementThread: " +e)
        Thread.sleep(300);
      }
    }catch(InterruptedException e){
      System.out.println("Exception caught in implementThread class");
    }
  }

}

public class Threads{

  public static void main(String argd[]){
    Thread t = Thread.currentThread();
    Thread c,d;
    extendsThread a = new extendsThread("First");
    extendsThread b = new extendsThread("Second");
    implementThread z = new implementThread();
    c = new extendsThread("third");
    try{
      System.out.println("Joining other threads in main");
      a.join();
      b.join();
      z.r.join();
    }catch(InterruptedException e){
      System.out.println("Error in main");
    }
    System.out.println("The name of the current thread is "+t);
    t.setName("Maggi");
    System.out.println("The new  name of the current thread is after changing"+t);
  }

}
