import java.io.*;
import java.util.*;

class M extends Thread{
    M(){System.out.println("Chil");
        new Thread();start();//System.out.println("Ch");
    }
    public void run(){
        System.out.println("Child alive");
    }
}

public class threadPgm{
    //void ru(){ System.out.println("ru");}
    public static void main(String arg[]){
       /* M m = new M();//System.out.println(m.isAlive());
        ru();
       System.out.println("Child ");
        try{
        m.join();}catch(Exception e){}System.out.println(m.isAlive());*/
        String s1 = "Java";
        String s2 = "Java";
        String s3 = s1;

        String s4 = new String("Java");
        String s5 = new String("Java");
        String s6 = s3+"i";

        if(s1==s2){System.out.println("s1 and s2");}
         if(s1==s3){System.out.println("s1 and s3");}
          if(s2==s3){System.out.println("s3 and s2");}


        if(s4==s5){System.out.println("s4 and s5");}
         if(s4==s6){System.out.println("s4 and s6");}
          if(s5==s6){System.out.println("s6 and s5");}

        if(s1==s4){System.out.println("s1 and s4");}
        if(s6==s3){System.out.println("s6 and s3");}
        //  if(s2==s3){System.out.println("s3 and s2");}
    }
}