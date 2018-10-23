import java.io.*;
import java.util.*;
import java.lang.*;
public class rowSht
{
    public static void main(String[] a)
    {
        int[][] m = {{1,2},{2,6},{5,7}};
        int[] k={1,2};
        
        for(int i=0;i<m.length-1;i++){
            int p=-1;
            for(int j=0;j<m[0].length;j++)
                {
                    int t=m[i+1][j];
                    m[i+1][j]=k[j];
                    k[j]=t;
                }
        }
        for(int j=0;j<m[0].length;j++)
            {
                m[0][j]=k[j];
            }
        for(int i=0;i<m.length;i++)
            {
                for(int j=0;j<m[0].length;j++){
                    System.out.print(m[i][j]+" ");
                }
                System.out.println();
            }
    }
}