import java.io.*;
import java.util.Scanner;

public class p3{
     public static void main(String ar[]){
        int m=0;int k=0;
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        String st="";
        String s="";
        while(m!=0){
            s+=m%2;
            m=m/2;
        }int num=0;int n=0;
        for(int i=0;i<s.length();i++){
            
            if('1'==s.charAt(i)){
                num+=0*Math.pow(2,i);//System.out.println(num+"  "+s.charAt(i));
            }else{
                num+=1*Math.pow(2,i);//System.out.println(num);
            }
            
        }

        System.out.println(num);
        
        
     }
}