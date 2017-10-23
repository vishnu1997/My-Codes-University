import java.io.*;
import java.util.*;
/*forest fire where select 1 tree and surroundingd all will burn */
class fire{
    boolean way(forest ft[][],int i,int j){
        boolean fl = false;
        for(int k=i-1;k<i+2;k++){
            for(int l=j-1;l<j+2;l++){
                if(!ft[k][l].st()&&ft[k][l].tw==1){
                    fl = true;
                }
            }
        }
        return fl;
    }
    void fi(forest ft[][],int i,int j){
        System.out.println(i+" "+j);
        if(!way(ft,i,j)){
            return ;
        }else{
            System.out.println("in");
            for(int k=i-1;k<i+2;k++){
                for(int l=j-1;l<j+2;l++){
                    if(!ft[k][l].st()&&ft[k][l].tw==1){
                        ft[k][l].t=ft[i][j].t+1;
                        ft[k][l].status=true;
                        //fi(ft,k,l);
                    }
                }
            }
            for(int k=i-1;k<i+2;k++){
                for(int l=j-1;l<j+2;l++){
                    if(ft[k][l].tw==1&&ft[k][l].t==ft[i][j].t+1){
                        fi(ft,k,l);
                    }
                }
            }
        }
    }
}
class forest{
    int tw;
    boolean status;
    int t;
    forest(int r){
        tw = r;
    }
    boolean st(){
        return status;
    }
}
public class ff{
    static int max(forest ft[][]){
        int max =-1;
        for(int i=0;i<ft.length;i++){
            for(int j=0;j<ft[i].length;j++){
                if(ft[i][j].t>max){
                    max=ft[i][j].t;
                }
            }
        }
        return max;
    }
    public static void main(String art[]){
        int n,m;
        Scanner in = new Scanner(System.in);
        m = 6;
        n = 6;
        int mat[][]=new int[][]{{0,0,0,0,0,0,0,0},{0,0,1,1,1,1,1,0},{0,1,0,0,0,0,0,0},{0,0,1,1,1,1,1,0},{0,0,0,0,0,0,1,0},{0,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
        forest ft[][]=new forest[m+2][n+2];
        for(int k=0;k<m+2;k++){             //input 
            for(int l=0;l<n+2;l++){
                //int mat = in.nextInt();
                ft[k][l] = new forest(mat[k][l]);
            }
        }
        int i,j;
        i=0;//i = in.nextInt();
        j=5;//j = in.nextInt();                   //get i,j values = where fire starts
        i++;j++;
        ft[i][j].status=true;
        ft[i][j].t=1;
        fire fr = new fire();
        fr.fi(ft,i,j);
        int mx = max(ft);
        System.out.println(mx);
    }
}