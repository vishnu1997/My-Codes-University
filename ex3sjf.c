#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>

struct task{
	int at,st;
	int cmp;int status;
}rr[10];

int dispacher(int c,int n){
	int i,index;
	int min=1000;
	for(i = 0;i<n;i++){
		if(rr[i].status!=1){
			if(rr[i].at<=c){
				if(rr[i].st<min){
					min = rr[i].st;
					index = i; 	
				}	
			}
		}
	}
	return index;	
}

int main(){
	int n;
	int i;
	int c = 0;
	int cur_t=0;
	printf("enter Number");
	scanf("%d",&n);
	
	for(i =0;i<n;i++){
		printf("enter the at");
		scanf("%d",&rr[i].at);
		printf("enter the st");
		scanf("%d",&rr[i].st);
		
	}
	i=0;
	int cur_id;
	while(i<n){
		cur_id = dispacher(c,n);
		c = rr[cur_id].st+c;
		rr[cur_id].status = 1;
		rr[cur_id].cmp = c; 
		i++;
	}
		
	for(i=0;i<n;i++){
		printf("the process is %d cmp is %d \n",i,rr[i].cmp);	
	}
	return 0;

}
