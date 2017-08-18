/*import java.io.*;

class tutorial{
	
	 static public void main(String args[]){
		 int j = Integer.parseInt(args[0]);
		 System.out.println("hiii"+j);
		 System.out.println("Math power"+Math.pow(2, (-2)));
		}

}*/
import java.io.*;
import java.util.*;
import java.math.BigInteger;

 class Solution {
    public static String fact(int n) {
       BigInteger fact = new BigInteger("1");
       for (int i = 1; i <= n; i++) {
           fact = fact.multiply(new BigInteger(i + ""));
       }
       return fact.toString();
   }
    

    public static void main(String[] args) {
      
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++)
            {
            int n=s.nextInt();
            for(int j=0;j<=n;j++)
             {v=(fact(n)/(fact(n-j)*fact(j)));
                int length= v.length();
               if(length>=9)
                 { v=v/(int)Math.pow(10,9);}
                System.out.print(v+" ");
            }
            System.out.println();
        }
    }
}