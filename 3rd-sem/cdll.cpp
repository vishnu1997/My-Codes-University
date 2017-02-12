#include<iostream>
using namespace std;
struct node{
int data;
node *slink;
node *plink;
};
node *head=NULL;
node* createnn(int d){
node *nn = new node;
nn->data=d;
nn->slink=NULL;
nn->plink=NULL;
return nn;
}
/////////////////////////////////////////////
//insert in the begining
void insertnn(node *beg){
node *temp=head;
if(temp == NULL){
head=beg;
head->slink=head;
head->plink=head;
}
else{
beg->slink=temp;
temp->plink->slink=beg;
beg->plink=temp->plink;
temp->plink=beg;
head=beg;
}
}
/////////////////////////////////////////////
//insert in the end
void insertend(node *beg){
node *temp=head;
do{
temp=temp->slink;}while(temp->slink != head);
temp->slink->plink=beg;
beg->slink=temp->slink;
temp->slink=beg;
beg->plink=temp;

}
/////////////////////////////////////////////
//insert at a specific position
void insertpos(node *beg){
int pos,i;
i=0;
cout<<"enter the posito";
cin>>pos;
if(pos==0){insertnn(beg); return;}
node *temp=head;
while(i<pos&&temp->slink!=head){
temp=temp->slink;
i++;
}
temp->plink->slink=beg;
beg->plink=temp->plink;
temp->plink=beg;
beg->slink=temp;

}
/////////////////////////////////////////////
//display function
void display(){
node *temp=head;
if(head!=NULL){
do{
cout<<temp->data;
temp=temp->slink;}while(temp != head);
}
}
/////////////////////////////////////////////
//delete function
void del(int d){
node *temp=head;
if(temp->slink==head&&temp->data==d){
head=NULL;
return;
}
while(temp->slink != head){
	if(temp->data==d){
	if(temp==head){
	temp->slink->plink=head->plink;
	temp->plink->slink=temp->slink;
	head=temp->slink;
	}
	else{
	temp->plink->slink=temp->slink;
	temp->slink->plink=temp->plink;
	}
 
}
temp=temp->slink;
}

}
/////////////////////////////////////////////
int main(){
node *p;
int d,c;
char b='y';
while(b == 'y'){
cout<<"enter option";
cin>>c;
switch(c){
case 1:
cout<<"enter data ";
cin>>d;
p=createnn(d);
insertnn(p);
display();
break;
case 2:
cout<<"enter data ";
cin>>d;
p=createnn(d);
insertend(p);
display();
break;

case 3:
cout<<"enter data ";
cin>>d;
p=createnn(d);
insertpos(p);
display();
break;
case 4:
cout<<"enter data to be deleted";
cin>>d;
del(d);
display();
break;
}
cout<<"do you want ot continue";
cin>>b;
}

return 0;
}
