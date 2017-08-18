import java.io.*;
import java.util.*;

public class sol{
    static void bes(int copy[][],int i,int j){
        for(int k=i+1;k>i-2;k--){
            for(int l=j+1;j>j-2;j--){
                copy[k][l]=0;
            }
        }
    }

    static int max(int c[]){
        int max = c[0];
        for(int i=0;i<c.length;i++){
            if(c[i]>max){
                max = c[i];
            }
        }
        return max;
    }

    static void cc(int c[][],int ma[][],int m,int n){
        for(int k=0;k<m+2;k++){             
            for(int l=0;l<n+2;l++){
                c[k][l] = ma[k][l]; 
            }
        }
    }
    static int cost(int mat[][],int i,int j,int c,int m,int n){
        int copy[][] = new int[m+2][n+2];
        mat[i][j]=0;
        cc(copy,mat,m,n);
        boolean a[] = new boolean[8];

        System.out.println("i = "+i+" j = "+j);
        if(mat[i-1][j-1]==1){               // NW 
            a[0]=true;
        }
        
        if(mat[i-1][j]==1){               // N 
            a[1]=true;
        }

        if(mat[i-1][j+1]==1){               // NE
            a[2]=true;
        }

        if(mat[i][j+1]==1){               // E
            a[3]=true;
        }

        if(mat[i+1][j+1]==1){               // SE 
            a[4]=true;
        }

        if(mat[i+1][j]==1){               // S 
            a[5]=true;
        }

        if(mat[i+1][j-1]==1){               // SW
            a[6]=true;
        }

        if(mat[i][j-1]==1){               // W 
            a[7]=true;
        }
        int co[] = new int[8];
        for(int k=0;k<8;k++){
            co[k] = c;
        }
        //bes(copy,i,j);
        
        if(a[0]){  
            copy[i-1][j-1] = 1;                             //NW
            co[0] = cost(copy,i-1,j-1,c+1,m,n); 
        }
        cc(copy,mat,m,n);

        //bes(copy,i,j);
        if(a[1]){
            copy[i-1][j]=1;
            co[1] = cost(copy,i-1,j,c+1,m,n); 
        }
        cc(copy,mat,m,n);
        //bes(copy,i,j);
        if(a[2]){
            copy[i-1][j+1]=1;
            co[2] = cost(copy,i-1,j+1,c+1,m,n); 
        }
        cc(copy,mat,m,n);
        bes(copy,i,j);
        for(int k=0;k<m+2;k++){             
            for(int l=0;l<n+2;l++){
                //[k][l] = ma[k][l]; 
                System.out.print(" 3  = "+copy[k][l]);
            }
        }
        System.out.println();
        //copy[2][2]=0;
        if(a[3]){
            copy[i][j+1]=1;
            
            co[3] = cost(copy,i,j+1,c+1,m,n); 
        }
        cc(copy,mat,m,n);
        bes(copy,i,j);
        //copy[1][2]=0;
        if(a[4]){
            copy[i+1][j+1]=1;
            co[4] = cost(copy,i+1,j+1,c+1,m,n); 
        }
        cc(copy,mat,m,n);
        bes(copy,i,j);
        if(a[5]){
            copy[i+1][j]=1;
            co[5] = cost(copy,i+1,j,c+1,m,n); 
        }
        cc(copy,mat,m,n);
        bes(copy,i,j);
        if(a[6]){
            copy[i+1][j-1]=1;
            co[6] = cost(copy,i+1,j-1,c+1,m,n); 
        }
        cc(copy,mat,m,n);
        //bes(copy,i,j);
        if(a[7]){
            copy[i][j-1]=1;
            co[7] = cost(copy,i,j-1,c+1,m,n); 
        }
        cc(copy,mat,m,n);

        for(int k=0;k<co.length;k++){
           //System.out.println("max value "+i+" "+j+" "+co[k]);
        }
        //for(int k=0;k<co.){}
        c = max(co);
        
        System.out.println("max value is "+c);
        return c;
    }

    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int n,m;
        m = 2;
        n = 2;
        int mat[][] = new int[][]{{0,0,0,0},{0,1,1,0},{0,0,1,0},{0,0,0,0}};
        //int mat[][]=new int[][]{{0,0,0,0,0,0,0,0},{0,0,1,1,1,1,1,0},{0,1,0,0,0,0,0,0},{0,0,1,1,1,1,1,0},{0,0,0,0,0,0,1,0},{0,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
       /* m = in.nextInt();
        n = in.nextInt();
        
        for(int k=0;k<m+2;k++){             //input 
            for(int l=0;l<n+2;l++){
                mat[k][l] = in.nextInt();
            }
        }
           */        
        int i,j;
        i=0;//i = in.nextInt();
        j=0;//j = in.nextInt();                   //get i,j values = where fire starts
        i++;j++;
        int o,p;                            // o p  for i,j values copy
        o = i;
        p = j;
        int c = 0;
        c = cost(mat,i,j,c,m,n);
        
        System.out.println("c value"+c);
    }

}