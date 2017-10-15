import java.io.*;
import java.util.Scanner;

public class pal{
     public static void main(String ar[]){
        int m=0;
        Scanner in = new Scanner(System.in); 
        String p=in.next();
        String st="";
        for(int i=p.length()-1;i>=0;i--){
            st+=p.charAt(i);
        }
        if(st.equals(p)){
            System.out.println("pal");
        }else{System.out.println("not pal");}
     }
}