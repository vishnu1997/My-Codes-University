//
//  hash1.cpp
//  
//
//  Created by Vishnu Vardhan Reddy on 11/2/16.
//
//

#include <iostream>
using namespace std;

struct node{
    int data;
    node *link;
};

node *head[5]={NULL,NULL,NULL,NULL,NULL};

node* createnn(int d){
    node *nn=new node;
    nn->data=d;
    nn->link=NULL;
    return nn;
}

void insertbeg(node *beg,int r){
    
    if(head[r]==NULL){
        head[r]=beg;
    }
    else{
        beg->link=head[r];
        head[r]=beg;
    }
}
void search(int s,int r){
    node *temp=head[r];
    while(temp->data!=s&&temp!=NULL){
        temp=temp->link;
    }
    
    if(temp!=NULL){
    cout<<"found";
    }
    else{
    cout<<"not found";
    }
}

int main(){
    node *p;
    char b='y';
    int d,n,k;
    cout<<"enter the no.of elemnsts";
    cin>>n;
    for(int i=0;i<n;i++){
    cout<<endl<<"value";
        cin>>d;
        k=d%5;
        p=createnn(d);
        insertbeg(p,k);
    }
   for(int i=0;i<3;i++){
    cout<<"enter value to be searched";
    cin>>d;
    k=d%5;
 
    search(d,k);
    }
    return 0;
}
