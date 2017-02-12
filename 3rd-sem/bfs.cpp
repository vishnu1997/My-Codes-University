//
//  bfs.cpp
//  
//
//  Created by Vishnu Vardhan Reddy on 10/19/16.
//
//

#include <iostream>
using namespace std;

struct node{
int data;
    node *link;
};

struct gnode{
    char name[10];
    int vi;
    node *eptr;
};
//////////////////////////////////////////
//queue
class queue{
    int q[10],f,r;
public:
    queue(){f=-1;r=-1;}
    int empty(){if(f==-1){return 1;}
    else {return 0;}
    }
    
    void enq(int x){
        r++;
        q[r]=x;
        if(f==-1){f++;}
    }
    int dequeue(){
        int x;
        if(f!=(-1)){
             x=q[f];
        }
        if(f==r){f=(-1);r=(-1);}
        else{f++;}
        return x;
    }
    
    
};
//////////////////////////////////////////
//stack
class stack{
    int s[10],top;
public:
    stack(){top=-1;}
    int empty(){if(top==-1){return 1;}
        else{return 0;}}
    void push(int x){
        top++;
        s[top]=x;
    }
    int pop(){
        int x;
        if(top!=-1){
            x= s[top];
            top--;
        }
        return x;
    }

};
//////////////////////////////////////////
//graph
class graph{
    gnode v[10];
    int n;
public:
    void construct(){
        int m,adj;
        node *p;
        cout<<"enter no. of vertices";
        cin>>n;
        for(int i=0;i<n;i++){
        cout<<"enter the name of vertex";
            cin>>v[i].name;
            v[i].eptr=NULL;
            cout<<"enter the no .of adjacent vertices";
            cin>>m;
            for(int j=0;j<m;j++){
            cout<<"enter the indexof adjacent vertex";
                cin>>adj;
                p=new node;
                p->data=adj;
                p->link=NULL;
                if(v[i].eptr==NULL){
                    v[i].eptr=p;
                }
                else{
                    node *t=v[i].eptr;
                    while(t->link!=NULL){t=t->link;}
                    t->link=p;
                }
            }
        }
    
    }
    void bfs(int u){
        queue q;
        node *t;
        int w;
        v[u].vi=1;
        q.enq(u);
        while(!q.empty()){
            u=q.dequeue();
            t=v[u].eptr;
            while(t!=NULL){
                w=t->data;
                if(v[w].vi==0){v[w].vi=1;
                    cout<<v[u].name<<"-->"<<v[w].name;
                    q.enq(w);
                }
                t=t->link;
            }
        }
        
    
    }
    void dfs(int u){
        stack s;
        node *t;
        int w;
        s.push(u);
        v[u].vi=1;
        while (!s.empty()) {
            u=s.pop();
            cout<<v[u].name;
            t=v[u].eptr;
            while(t!=NULL){
                w=t->data;
                if(v[w].vi==0){v[w].vi=1;
                   // cout<<v[u].name<<"\t"<<v[w].name;
                    s.push(w);
                }
                t=t->link;
            }
        }
        
    }
    
    void initialize(){
        for(int i=0;i<10;i++){
            v[i].vi=0;
        }
    }
    void display(){
    cout<<"no.\t"<<"nzme\t"<<"adjjacent"<<endl;
        for(int i=0;i<n;i++){
            cout<<i<<v[i].name<<"\t";
            node *t = v[i].eptr;
            while (t!=NULL) {
                cout<<"-->"<<t->data;
                t=t->link;
               
            }
             cout<<endl;
        }
    }
};
//////////////////////////////////////////
int main(){
    graph g;
    int d;
    g.construct();
    g.initialize();
    g.display();
    cout<<"enter index";
    cin>>d;
    g.dfs(d);
    return 0;
}
