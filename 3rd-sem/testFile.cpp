//
//  testFile.cpp
//  
//
//  Created by Vishnu Vardhan Reddy on 10/19/16.
//
//

#include<iostream>
using namespace std;
#define row 7
#define col 7
#define infi 1000
class prim
{
    int graph[row][col],nodes;
public:
    prim(){
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                graph[i][j]=0;
    }
    void creategraph()
    {int i,j;
        cout<<"total no.nodes";cin>>nodes;
        cout<<"nter adja.matrix";
        for(int i=0;i<nodes;i++)
        {for(int j=i;j<nodes;j++)
        {cout<<"enter adjacency matrix:"<<i<<"to"<<j;cin>>graph[i][j];
            graph[j][i]=graph[i][j];}}
        for(int i=0;i<nodes;i++)
        {for(int j=0;j<nodes;j++)
        {if(graph[i][j]==0)
            graph[i][j]=infi;}}
        
        for(int i=0;i<nodes;i++)
        {for(int j=0;j<nodes;j++){
            cout<<graph[i][j];
            cout<<endl;
        }}
    }
    void primalgo()
    {
        int sel[row],i,j,ne,min,x,y;
        for(i=0;i<nodes;i++)
            sel[i]=0;
        sel[0]=1;
        ne=0;
        while(ne<nodes-1)
        {min=infi;
            for(i=0;i<nodes;i++)
            {if(sel[i]==1)
            {
                for(int j=0;j<nodes;j++)
                {if(sel[j]==0)
                {if(graph[i][j]<min)
                {min=graph[i][j];x=i;y=j;
                }}}}}
                sel[y]=1;
                cout<<x<<"-->"<<y<<"\n";
                ne=ne+1;
            }}
};
    int main()
    {prim mst;cout<<"p.algo to find mst";
        mst.creategraph();
        mst.primalgo();return 0;}
