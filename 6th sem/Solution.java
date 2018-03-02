import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void almostSorted(int[] arr) {
        // Complete this function
        int[] copy1 = new int[arr.length];
        System.arraycopy(arr,0,copy1,0,arr.length);
        Arrays.sort(copy1);
        if(Arrays.equals(arr,copy1)){
            System.out.println("yes");
            return ; 
        }
        int c=0;int pos=0;int end=0;
        boolean fl=false;
        boolean pl=true;
        int[] er=new int[2];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==copy1[i]){
                if(fl){
                    end=i;
                    fl=false;
                }
                
            }else{
                c++;
                if(c<=2){
                    er[c-1]=i+1;
                }
                if(pl){
                    pos=i;
                    pl=false;
                    fl=true;
                }
            
            }
        }
        
        
        if(c==1){
            System.out.println("no");
            return ;
        }
        if(c==2){
            System.out.println("yes");
            System.out.println("swap "+(er[0])+" "+(er[1]));
            return ;
        }
        if(c>2){
            int x = end-pos;
            if(c==x){
                System.out.println("yes");
                System.out.println("reverse "+(pos+1)+" "+end);
                return ;
            }else{
                System.out.println("no");
                return ;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        almostSorted(arr);
        in.close();
    }
}

