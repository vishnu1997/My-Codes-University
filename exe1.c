/*	
	This program is used to create a connection between parent and child.
	For further verification a message is sent from parent to child.
*/

#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>

void sort(int a[]){
int t,i,j;
for(i=0;i<10;i++){
}
	
}

int main(){
	int p[2];
	int i;
	int pid;
	int input[10],output[10];
	if(pipe(p)==-1){//pipe creation failed
		printf("pipe creation failed");	
	}else{//pipe creation succesful
		pid = fork();
		if(pid){//parent process 
			for(i=0;i<10;i++){
				printf("Enter value in %d",i);
				scanf("%d",&input[i]);
			}
			write(p[1],input,sizeof(input));
			sleep(2);
		}
		else{//child process
			read(p[0],output,sizeof(output));
			sort(output);
			for(i=0;i<10;i++){
				printf("the data is %d",(output[i]));}	
		}		
	}

}


