class Queue
{
  int q[];
  int front, rear;
  boolean empty, full;
  public Queue(int size)
  {
    empty = true;
    full = false;
    q = new int[size];
    front = rear = -1;
  }
  synchronized public void put(int x)
  {
    try
    {
      while (full)
      {
          wait();
      }
      rear = (rear+1)%q.length;
      q[rear]=x;
      if (front==-1) front=0;
      System.out.println("Put : " + q[rear]);
      if ((rear+1)%q.length==front)
          full = true;
      empty = false;
      notifyAll();
    }
    catch(InterruptedException e)
    {
      System.out.println("Exception : " + e);
    }
  }
  
  synchronized public int get()
  {
    int x=0;
    try 
    {
      while (empty)
      {
        wait();
      }
      x = q[front];
      System.out.println("Got : " + x);
      if (front == rear)
      {
          front = rear = -1;
          empty = true;
      }
      else
          front=(front+1)%q.length;
      full = false;
      notifyAll();
    }
    catch(InterruptedException e)
    {
      System.out.println("Exception : " + e);
    }
    return x;
  }
}

class Producer implements Runnable
{
   Queue que;
   Thread t;
    
   public Producer(Queue q)
   {
     que = q;
     t = new Thread(this, "Producer");
     t.start();
   }
   
   public void run()
   {
     try
     {
       for(int i=1; ; i++)
       {
         que.put(i);
         Thread.sleep(500);
       }  
     }
     catch(InterruptedException e)
     {
       System.out.println("Exception : " + e);
     }    
   } 
}

class Consumer implements Runnable
{
   Queue que;
   Thread t;
    
   public Consumer(Queue q)
   {
     que = q;
     t = new Thread(this, "Consumer");
     t.start();
   }
   
   public void run()
   {
     try
     {
       for(int i=1; ; i++)
       {
         que.get();
         Thread.sleep(1000);
       }  
     }
     catch(InterruptedException e)
     {
       System.out.println("Exception : " + e);
     }    
   } 
}

public class ProCon
{
   public static void main(String args[])
   {
     Queue q1 = new Queue(10);
     Producer p = new Producer(q1);
     Consumer c = new Consumer(q1);
     try { p.t.join(); c.t.join(); } catch(InterruptedException e) {}
   }
}