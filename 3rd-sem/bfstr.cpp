//
//  bfstr.cpp
//  
//
//  Created by Vishnu Vardhan Reddy on 10/31/16.
//
//

#include <iostream>
using namespace std;
struct node{
    int data;
    node *link;
};
struct gnode{
    node  *eptr;
    char name[10];
    int visited;
    
    
};

class queue{
    int front,rear;int q[10];
public:
    queue(){front=-1;rear=-1;}
    int empty(){
        if(front==-1){return 1;}
        else{return 0;}
    }
    void enqueue(int d){
        rear++;
        q[rear]=d;
        if(front==-1){front=0;}
    }
    int dequeue(){
        int x;
        if(front!=-1){
            x=q[front];}
        if(front==rear){front=-1;rear=-1;}
        else{front++;}
        return x;
    }
};

class graph{
    gnode v[10];
    int n;
public:
    void initialize(){
        for(int i=0;i<10;i++){
            v[i].visited=0;}
    }
    void construct(){
        int m,i,j,adj;
        node *temp;
        node *p;
        cout<<"enter the no.of vertices";
        cin>>n;
        for(i=0;i<n;i++){
        cout<<"enter the name of vertex";
            cin>>v[i].name;
            v[i].eptr=NULL;
            cout<<"enter no of adjacent vertices";
            cin>>m;
            for(j=0;j<m;j++){
            cout<<"enter the index";
                cin>>adj;
                p=new node;
                p->data=adj;
                p->link=NULL;
                if(v[i].eptr==NULL){
                    v[i].eptr=p;
                }
                else{
                     temp=v[i].eptr;
                    while(temp->link!=NULL){
                        temp=temp->link;
                    }
                    temp->link=p;
                }
            }
        
        }
    }
    void display(){
        int i,j;
        node *temp;
        for(i=0;i<n;i++){
            temp=v[i].eptr;
            cout<<i<<v[i].name<<"\t";
            while(temp!=NULL){
                cout<<"-->"<<temp->data;
                temp=temp->link;
                
            }
            cout<<endl;
        }
        
    }

    void bfs(int d){
        queue q;
        int s,r;
        node *t;
        q.enqueue(d);
        v[d].visited=1;
        while(!q.empty()){
            s=q.dequeue();
             t=v[s].eptr;

            while(t!=NULL){
                r=t->data;
                if(v[r].visited==0){
                    v[r].visited=1;
                    cout<<v[s].name<<"-->"<<v[r].name;
                    q.enqueue(t->data);}
                t=t->link;
            }
        }
    }
    
};

int main(){
    graph g;
    int d;
    g.construct();
   
    g.initialize();
    g.display();
    cout<<"maggi";
    cin>>d;
    g.bfs(d);
    return 0;
    
}

