//
//  dll.cpp
//  
//
//  Created by Vishnu Vardhan Reddy on 10/18/16.
//
//

#include <iostream>
using namespace std;
/////////////////////////////////
struct node{
    int data;
    node *plink;
    node *slink;
};
/////////////////////////////////
node *head=NULL,*nn;
node* createnn(int n){
    nn=new node;
    nn->data = n;
    nn->slink= NULL;
    nn->plink = NULL;
    return nn;
}
/////////////////////////////////
//insert in the begining
void insertbeg(node *beg){
    if(head==NULL){head=beg;}
    else{
        beg->slink=head;
        head->plink=beg;
        head=beg;
    }
}
/////////////////////////////////
//insert at a specific position
void insertpos(node *p){
    node *temp=head;int i,pos;
    cout<<"enter position";
    cin>>pos;
    i=0;
    while(i<=pos){
        temp=temp->slink;
        i++;}
    p->plink=temp;
    p->slink=temp->slink;
    temp->slink->plink=p;
    temp->slink=p;

}

/////////////////////////////////
//display function
void display(){
    node *temp;
    temp=head;
    if(head != NULL){
    while(temp != NULL){
     cout<<temp->data;
        temp=temp->slink;
    }}
}
/////////////////////////////////
//delete function
void del(int d){
    if(head==NULL){cout<<"no elemnts";return;}
    node *temp;
    temp=head;
    while (temp != NULL){
        if(temp->data == d){
            if(temp==head){head=head->slink;
                if(head!=NULL){
                    head->plink=NULL;}}
            else{
                if(temp->slink==NULL){
                    temp->plink->slink=NULL;}
                
            
            else{temp->slink->plink=temp->plink;
                temp->plink->slink=temp->slink;}
            }}
        temp=temp->slink;
    }

}

/////////////////////////////////

int main(){
    node *dll;
    int d,pos;
    char b= 'y';
    char c;
    while(b == 'y'){
        cout<<"Enter choice  for dll";
        cin>>c;
        switch(c){
            case '1':
                cout<<"enter element to be inseerted";
                cin>>d;
                dll=createnn(d);
           
                insertbeg(dll);
                display();
                break;
                case '2':
                cout<<"enter element ot be  deleted";
                cin>>d;
                del(d);
                display();
                break;
                case '3':
                cout<<"enter data";
                cin>>d;
                dll=createnn(d);
                insertpos(dll);display();
        }
        cout<<"do u want to continue";
        cin>>b;
    }
    return 0;
}
