//
//  generalToBinary.cpp
//  
//
//  Created by Vishnu Vardhan Reddy on 11/2/16.
//
//

#include <iostream>
using namespace std;

struct node{
    char data;
    node *left;
    node *right;
};

struct stack{
    int level;
    node *loc;
};
node *root=NULL;
stack s[10];
int top=-1;

node* createnn(char d){
    node *nn=new node;
    nn->data=d;
    nn->left=NULL;
    nn->right=NULL;
    return nn;
}

void push(int lvl,node *pos){
    top++;
    s[top].level=lvl;
    s[top].loc=pos;
}

stack peek(){
    return s[top];
}

void pop(){
    top--;
}

void gtob(int lvl,node *beg){
    stack k;
    k=peek();
    node *t=k.loc;
    if(k.level<lvl){
        t->left=beg;
    }
    else{
        while(k.level>lvl){
            pop();
            k=peek();
        }
        if(k.level<lvl){
            cout<<"mistake;";return;}
        k.loc->right=beg;
        pop();}
        push(lvl,beg);
        return;
    
}

void display(node *temp){
    if(temp!=NULL){
        display(temp->left);
        cout<<temp->data;
        display(temp->right);
    }
    return;
}

int main(){
    int n;
    char d;
    node *nn;
    int l;
    char b='y';
    cout<<"enter root data";
    cin>>d;
    nn=createnn(d);
    root=nn;
    push(0,root);
    cout<<"enter the no fo";
    cin>>n;
    for(int i=0;i<n;i++){
    cout<<"enter level";
        cin>>l;
        cout<<"enter cahracter";
        cin>>d;
        nn=createnn(d);
        gtob(l,nn);
    }
    
    display(root);
    return 0;
}
