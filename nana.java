import java.util.*;
import java.io.*;

public class nana{
    public static void main(String ar[]){
        int n;
        
        int k=0;
        Scanner in = new Scanner(System.in);
        System.out.println("enter the no of persons");
        n = in.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i]=0;
        }
    
        for(int i=0;i<(Math.log(n)/Math.log(2));i++){ 
            for(int j=0;j<n;j++){
                
                if(a[j]==0&&k==0){
                    k++;
                }
                else{
                    if(a[j]==0){
                        k=0;
                    // h++;
                    }
                    a[j]=1;
                    
                }
                
            }
        
        }
    
        for(int i=0;i<n;i++){
            if(a[i]==0){System.out.println(i+1);}
        }
    
    }
}