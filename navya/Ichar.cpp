// ichar.cpp
// file input with characters
#include <fstream>                //for file functions
#include <iostream>
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
////////////////////////
void display(node *t){
    
    
    if(t == NULL){return;}
    display(t->left);
    cout<<t->data;
    display(t->right);
}


////////////////////
int main()
   {
       node *p;
   char ch,ch2[100];                       //character to read
       int i,j;
       i=0;
       j=0;
       string s,s1[10];
       ifstream infile("text.txt");   //create file for input
   while( infile )                //read until EOF or error
      {
      infile.get(ch);             //read character
      
          ch2[i]=ch;
          i++;
      //    cout << ch;                 //display it
      }
       i=0;
       while(ch2[i]!='\0'){

           if(ch2[i]!=' '){
               s=ch2[i];
               s1[j]=s1[j]+s;
               
           }
           else{j++;}
           i++;

       }
       
       for(int k=0;k<=j;k++){
       p=createnn(s1[k]);
       //cout<<p->data;
       insert(p);
           }
       
     //  cout<<s1[0]<<endl<<s1[1];
      // cout << endl;
       display(root);
   return 0;
   }
