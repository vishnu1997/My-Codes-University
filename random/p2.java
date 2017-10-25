import java.io.*;
import java.util.Scanner;

public class p2{
     public static void main(String ar[]){
        int m=0;int k=0;
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        if(m%2==0){
        int n = (m+1)/2;
        System.out.println(((m*n)+n));
        }else{
            int n = (m+1)/2;
            System.out.println((m*n));
        }
        
        
     }
}