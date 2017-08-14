#include<iostream>
using namespace std;

int top=0;
int rear = 0;
struct list{
    int at,st,fl,status,cmp,en;
}rr[10];

void enqueue(int a[],int d,int n=10){
    if(!(top>n-1)){
        a[top]=d;
    }else{
        printf("queue full");
    }
    top++;
}

int dequeue(int a[]){
    int d;
    if(top!=rear){
        d = a[rear];
        rear++;
        if(top==rear){
            top = 0;
            rear = 0;
        }
    }else{printf("queue empty");
        d = -1; 
    }

    return d;
}

int empty(){
    if(top==rear){
        return 0;
    }
    return 1;
}

int main(){
    int tq, n, i, x, d, k;
    int a[10];
    int cur=0;
	printf("enter Number");
	scanf("%d",&n);
    cout<<"enter the quantum";
		cin>>tq;
	for(i =0;i<n;i++){
		cout<<"enter the at";
	    cin>>rr[i].at;
		cout<<"enter the st";
		cin>>rr[i].st;
		
        rr[i].status=0;	       //status flag to check completed or not
        rr[i].cmp = 0;         //cmp for storing completed time
        rr[i].fl = 1;          //fl for checking if its the current process
        rr[i].en = 1;          //for checking if it is present in the queue or not
    }
    
    for(i = 0;i<n;i++){
        if(rr[i].at==0){
            x = i;
        }
    }
    i = 0;
    enqueue(a,x,10);        //place the first process in the queue
    rr[x].en = 0;
    while(empty()){         //loop till queue is empty
        d = dequeue(a);     //take the first elemnt from the queue
        rr[d].en = 1;       
        cout<<" d value "<<d<<"\n";
        if(d!=-1){
            rr[d].fl=0;
            if(rr[d].st<=tq){       //check whether it's completion time is less the time quantum
                cur +=rr[d].st;
                rr[d].status = 1;
                rr[d].cmp = cur;
                rr[d].en = 0;
            }else{
                cur +=tq;
                rr[d].st -= tq; 
                
            }
            
            for(k=0;k<n;k++){           /*if any process arrival time is less 
                                        than current time then place it in queue*/
                if(rr[k].at<=cur&&(rr[k].fl!=0)&&(rr[k].en!=0)){
                    enqueue(a,k,10);
                    rr[k].en = 0;
                }
            }
            
            if(rr[d].status!=1){        /*place the current process 
                                        in the q if its not completed*/
                enqueue(a,d,10);
                rr[d].en = 0;
                cout<<d<<"ssss\n";
            }
            
            if(rr[d].status!=1){
            rr[d].fl=1;}
        }
    }

    for(i=0;i<n;i++){
        printf(" the cmp times are  %d :::: %d \n",i,rr[i].cmp);
    }
    return 0;
}