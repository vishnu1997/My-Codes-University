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
        for(int i=0;i<n;i++){//If a[i] = 0 then person is alive if a[i]=1 then dead 
            a[i]=0;
        }
    
        for(int i=0;i<(Math.log(n)/Math.log(2));i++){ 
            for(int j=0;j<n;j++){
                if(a[j]==0&&k==0){//k=0 implies person has knife
                    k++;//now k = 1
                }
                else{
                    if(a[j]==0){ //here k=1 hence the person dies
                        k=0;//again the next person should get the knife
                    // h++;
                    }
                    a[j]=1;//a[j]=1 implies person dead.
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(a[i]==0){//true if that person is alive
                System.out.println(i+1);}
        }
    }
}