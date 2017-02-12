//
//  bst.cpp
//  
//
//  Created by Vishnu Vardhan Reddy on 10/18/16.
//
//

#include <iostream>
#include<string>
using namespace std;

struct node{
    string data;
    node *left;
    node *right;
};
////////////////////////////////
node *root=NULL,*nn;
node* createnn(string d){
    nn=new node;
    nn->data=d;
    nn->left=NULL;
    nn->right=NULL;
    return nn;
}
////////////////////////////////
void insert(node *beg){
    node *temp=root,*pt;
    if(temp==NULL){
        root = beg;}
    else{
        
        while(temp != NULL){
            pt=temp;
            if(beg->data <temp->data){temp=temp->left;
        }
            else{temp=temp->right;}
    }
        if(pt->data > beg->data){
            pt->left=beg;
        }else{pt->right=beg;}
    }
 
}
node* del(node *tree,string d){
    node *temp;
    string a;
    if(tree==NULL)return tree;
    if(d<tree->data){
        tree->left=del(tree->left,d);
    }
    else{
        if(d>tree->data){
            tree->right=del(tree->right,d);
        }
        else{
            if(tree->left==NULL){
                temp=tree;
                tree=tree->right;
                delete temp;
           return tree;
            }
            else if(tree->right==NULL){
                temp= tree;
                tree=tree->left;
                delete temp;
               return tree;
            }
            else{
                temp=tree->right;
                while(temp->left != NULL){
                    temp=temp->left;
                }
                tree->data=temp->data;
                tree->right=del(tree->right,temp->data);
          
            }
        }
    
    }
    return tree;
}

////////////////////////////////
    void display(node *t){
    

        if(t == NULL){return;}
        display(t->left);
        cout<<t->data;
        display(t->right);
    }
    
////////////////////////////////
int main(){
    node *p;
    char b='y';
    char c;
    string d;
    while(b=='y'){
        cout<<"Enetr our choice";
        cin>>c;
        switch (c) {
            case '1':
                cout<<"ENter data to be inserted";
                cin>>d;
                p=createnn(d);
                //cout<<p->data;
                insert(p);
                display(root);
                break;
            case '2':
                cout<<"enter the number to be deleted";
                cin>>d;
                root=del(root,d);
                
            default:
                break;
        }
        cout<<"do you want to continue";
        cin>>b;
    }
    return 0;
}
