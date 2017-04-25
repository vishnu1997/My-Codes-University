import java.io.*;
import java.util.*;

public class fcopy{
    public static void main(String arg[]){
        try{
            String s = "fly away with me";
            int c;
            FileReader fr = new FileReader("filedemo.txt");
            while((c = fr.read()) != -1){ System.out.print((char) c);
            s+=Character.toString((char)c);}
            System.out.println(" " +s);
            fr.close();
             FileWriter fw =new FileWriter("filedemo2.txt");
             fw.write(s);fw.close();
        }catch(Exception e){System.out.println("Exception is "+e);}
    }
}