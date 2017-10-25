#include<iostream>
using namespace std;

struct list{
    int at,st,rt,status,cmp;
}rr[10];

int main(){
    int tq=1;
    int n, i, d;
    int k=0;
    //int a[10];
    int cur=0;
	printf("enter Number");
	scanf("%d",&n);
	for(i =0;i<n;i++){
		cout<<"enter the at";
	    cin>>rr[i].at;
		cout<<"enter the st";
		cin>>rr[i].st;
		rr[i].rt=rr[i].st;
        rr[i].status=0;	    //status flag to check completed or not
        rr[i].cmp = 0;      //cmp for storing completed time  
    }
    while(k<n){     //loop till all process have completed
        int in = 0;
        int s = 10000;
        for(int i=0;i<n;i++){     //selects which process has least remaining time
            if(rr[i].at<=cur){
                if(rr[i].rt<s&&rr[i].status!=1){
                    s = rr[i].rt;
                    in = i;
                }
            }
        }
        
        if(rr[in].rt<=tq){    //check for each cycle if it's completed
        cur +=rr[in].rt;
        rr[in].status = 1;
        rr[in].cmp = cur;
        k++;
        }else{
        cur +=tq;
        rr[in].rt -= tq; 
        }
    }
    for(i=0;i<n;i++){
        printf(" the cmp times are  %d :::: %d \n",i,rr[i].cmp);
    }
    return 0;
}