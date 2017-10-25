import java.io.*;
import java.util.Scanner;

public class prim{
     public static void main(String ar[]){
        int m=0;int k=0;
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int l = in.nextInt();
        for(int j=s;j<=l;j++){int u=0;
        for(int i=1;i<=j/2;i++){
            if(j%i==0){
                u++;
            }

        }
        if(u==1){
            System.out.println(""+j);
        }
    }
     }
}