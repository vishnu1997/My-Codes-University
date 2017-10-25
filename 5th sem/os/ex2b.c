#include<stdio.h>
#include<unistd.h>
#include<sys/types.h> 				//for msgget
#include<sys/msg.h>   				//for msgget
#include<sys/ipc.h>  				//for msgget

//struct mes for msgget function argument
struct mes{
	long type;
	char dat[200];
}buf;

//main function starts
int main(){
	int msqid;				//to store the id 	
	int i;	
	//creates a message queue and returns id	
	msqid = msgget(421,0666|IPC_CREAT);//421 is key value
	
	//put 3 messages into the message queue
	for(i=0;i<3;i++){	
		printf("enter the type");
		scanf("%ld",&buf.type);
		printf("enter the message");
		scanf("%s",buf.dat);
		msgsnd(msqid,&buf,sizeof(buf),0);
	}
}

