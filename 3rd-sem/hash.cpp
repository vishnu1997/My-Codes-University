//
//  hash.cpp
//  
//
//  Created by Vishnu Vardhan Reddy on 8/16/16.
//
//

#include <iostream>
using namespace std;

struct node{
    int data;
    node* link;
};


struct node *head[5]={NULL,NULL,NULL,NULL,NULL};
node* newn;
///////////////////////////////////
node* newnode(int d){
    node *newn = new node;
    newn->data=d;
    newn->link=NULL;
    return newn;
}
//////////////////////////////////
void insertbeg(node *beg,int r){
      if(head[r]==NULL){
        head[r]=beg;
    }
    else{
        beg->link=head[r];
        head[r]=beg;
    }
}
//////////////////////////////////
bool search(int r,int d){
    node* temp=head[r];
    if(temp==NULL){cout<<"empty list"; return false;}
else{
    while(temp!=NULL){if(temp->data==d){
        return true;
    }
        else{temp=temp->link;}}
}
    return false;
}
///////////////////////////////////
void display(int r){
    node* temp=head[r];
    if(temp==NULL){cout<<"empty list";}
    else{
        while(temp!=NULL){
    
            cout<<temp->data;
            temp=temp->link;}
    }
}
///////////////////////////////////
int main(){
    node *np;
    int d,s,r;
    char b='y';
    while(b=='y'){
        cout<<"Enter element in the sll";
        cin>>d;
        r=d%5;
        //cout<<endl<<r;
        np=newnode(d);
        insertbeg(np,r);
        display(r);
        
        cout<<"Do you want to continue";
        cin>>b;
    }
    b='y';
  while(b=='y'){
      cout<<"Enter the number to be searched";
      cin>>s;
      if(search(s%5,s)){cout<<endl<<"element found";}
      else{cout<<"elemnt not found";}
      cout<<endl<<"Do you want to continue";
      cin>>b;
    }
    
    
    return 0;
}
