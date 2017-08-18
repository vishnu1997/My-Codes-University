import java.io.*;
import java.util.*;

public class filewrite{
    public static void main(String arg[])throws IOException{
        FileWriter fw =new FileWriter("filedemo.txt");
        String s = "king kong eats maggi";
        try{
        // fw = new FileWriter("filedemo.txt");
        }catch(Exception e){System.out.println("Exception is "+e);}
        try{
         fw.write(s);fw.close();
         }catch(Exception e){System.out.println("Exception is "+e);}
    }
}