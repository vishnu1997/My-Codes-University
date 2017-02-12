//
//  mwst.cpp
//  minimum weight spanning tree using adjacency matrix
//
//  Created by Vishnu Vardhan Reddy on 10/19/16.
//
//

#include <iostream>
using namespace std;

#define row 7
#define col 7
#define infi 1000

class prim{
    int g[row][col],nodes;
public:
    prim(){
        for(int i=0;i<row;i++){
            for(int j=0;j<row;j++){
                g[i][j]=0;
        }
    }
    }
    void creategr(){
    cout<<"enter the no.of nodes";
        cin>>nodes;
        cout<<"enter adjacency matrix";
        for(int i=0;i<nodes;i++){
            for(int j=0;j<nodes;j++){
                cin>>g[i][j];
            }}
        for(int i=0;i<nodes;i++){
            for(int j=0;j<nodes;j++){
                if(g[i][j]==0){
                    g[i][j]=1000;}
            }}
        
        cout<<"the matrix is";
        for(int i=0;i<nodes;i++){
            for(int j=0;j<nodes;j++){
               cout<<g[i][j];
            }}
    }
    void palgo(){
        int sel[row],i,j,x,y,min,ne;
        
        for(i=0;i<row;i++){sel[i]=0;}
        sel[0]=1;
        ne=0;
        while(ne<nodes-1){
            min=infi;
            for(i=0;i<nodes;i++){
                if(sel[i]==1){
                    for(j=0;j<nodes;j++){
                        if(sel[j]==0){
                            if(g[i][j]<min){
                                min=g[i][j];
                                x=i;
                                y=j;
                            }
                        }
                    }
                }
            }
            sel[y]=1;
            cout<<x<<"-->"<<y<<"\n";
            ne=ne+1;
        }
    }
    
};

int main(){
    prim m;
    m.creategr();
    m.palgo();
    return 0;
    
}
