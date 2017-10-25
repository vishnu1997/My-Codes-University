#include<stdio.h>
/*Thread scheduling where a process is selected for execution by the minimum no of thread*/
struct Thread{
    int st, cmp, status;
};

struct pro{
    int at, st, cmp, nt, ntc, status;
    struct Thread t[5];
}list[10];

int main(){
    int n;
    int cur_time = 0;
    int i, k, j, pid, tid, fl, min;
    printf("\nEnter the number of processes : ");
	scanf("%d",&n);
    for(i=0;i<n;i++){
        printf("\nEnter the details of the %d process : ",i);
		printf("\nEnter the arrival time : ");
		scanf("%d",&list[i].at);		
		printf("\nEnter the no of threads : ");
		scanf("%d",&list[i].nt);
        for(k=0;k<list[i].nt;k++){
            printf("\n-->Enter the service time of thread %d: ",j);
			scanf("%d",&list[i].t[k].st);
			list[i].t[k].status=0;
		}
		list[i].status=0;
		list[i].ntc=0;
    }

    i=0;
    while(i<n){//loop till all the process are completed
        pid = -1;
        min=3000;//set some random large value
        for(k=0;k<n;k++){//loop till u get the process with the minimum no of threads
            if(list[k].status!=1){
                if(list[k].at<=cur_time){
                    if(min>list[k].nt){
                        min = list[k].nt;
                        pid = k; 
                    }
                }
            }
        }

        if(pid!=-1){//if the process arrival time is less than the current time
            for(k=0;k<list[pid].nt;k++){//complete processing every thread in the process
                if(list[pid].t[k].status!=1){//if the thread is not completed
                    cur_time+=list[pid].t[k].st;
                    list[pid].t[k].cmp = cur_time;//note down the completion time of the thread
                    list[pid].t[k].status=1;
                }
            }
            i++;//increment that a process has completed
            list[pid].status = 1;//make the status of the process as 1 to imply completion
            list[pid].cmp = cur_time;//note down the total completion time of the process
        }else{
            cur_time++;
        }
    }
    for(i=0;i<n;i++)
	{   printf("\nPID\tAT\tFT"); 
        printf("\n%d\t",i);          
        printf("%d\t",list[i].at);
        printf("%d\t",list[i].cmp);
        printf("\nThreads of process %d\n",i);
        printf("TID\tST\t\tFT");
        for(j=0;j<list[i].nt;j++)
        {
            printf("\n%d \t",i);
		    printf("%d          \t",list[i].t[j].st);
		    printf("%d          \t",list[i].t[j].cmp);
		    printf("\n");
        }
    }
}
