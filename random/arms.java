import java.io.*;
import java.util.Scanner;

public class arms{
    public static void main(String ar[]){
        int m=0;
        Scanner in = new Scanner(System.in); 
        String p=in.next();
        for(int i=0;i<p.length();i++){
            m += Integer.parseInt(p.charAt(i)+"")*Integer.parseInt(p.charAt(i)+"")*Integer.parseInt(p.charAt(i)+""); 
        }
        if(m==(Integer.parseInt(p))){
            System.out.println("armstarong");
        }else{
        System.out.println("not amrmast787rong");}
    }
}