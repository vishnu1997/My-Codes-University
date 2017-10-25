import java.io.*;
import java.util.Scanner;

public class fac{
     public static void main(String ar[]){
        int m=0;int k=0;
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        for(int i=1;i<=m/2;i++){
            if(m%i==0){
                k+=i;
            }
        }
        if(k==m){System.out.println("per");}
     }
}