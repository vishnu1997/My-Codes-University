import java.nio.file.Files;
import java.io.*;

public class fileappend{
    public static void main(String arg[])throws IOException{
        File f = new File("filedemo.txt");
        String s;
       // try {
                byte[] bytes = Files.readAllBytes(f.toPath());
                
         //       }catch(Exception e){System.out.println("Exception is "+e);}
                s= new String(bytes);
                System.out.println("the data is "+s);
                s +="the data is "; 
                //f.close();
           FileWriter fw = new FileWriter("filedemo.txt");
           try{
         fw.write(s);fw.close();
         }catch(Exception e){System.out.println("Exception is "+e);}   
    }
}