#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>

struct prio{
	int at,st,ft,pr,status;
}list[10];

int dispatcher(int c,int n){
	int index = 0;
	int i;
	int high_pr = 0;
	for(i =0;i<n;i++){
		if(list[i].status!=1){
			if(list[i].at<=c){
				if(list[i].pr>high_pr){
					high_pr = list[i].pr;
					index = i;
				}
			}
		}
	}
	return index;
}

int main(){
	int n,i,pid,cur_time;
	printf("enter the no");
	scanf("%d",&n);
	for(i = 0;i<n;i++){
		printf("enter the at");
		scanf("%d",&list[i].at);
		printf("enter the ST");
		scanf("%d",&list[i].st);
		printf("enter the PR");
		scanf("%d",&list[i].pr);
		list[i].status = 0;
	}
	i = 0;
	cur_time = 0;
	while(i<n){
		pid = dispatcher(cur_time,n);
		list[pid].ft = cur_time + list[pid].st;
		list[pid].status = 1;
		cur_time +=list[pid].st;
		i++;
	}
	for(i = 0;i<n;i++){
		printf("enter the at %d",i);
		printf("enter the FT: %d",list[i].ft);
	}
}
