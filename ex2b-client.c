#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/msg.h>
#include<sys/ipc.h>

struct mes{
	long type;
	char dat[200];
}buf;

int main(){
	int msqid;
	int i;	
	msqid = msgget(421,0666);//421 is the key value
	//get any 3 messages from the message queueby specifing the type
	for(i=0;i<3;i++){	
		printf("enter the type");
		scanf("%ld",&buf.type);
		//gets the data of the specified type 
		msgrcv(msqid,&buf,sizeof(buf),buf.type,0);
		printf("the message is %s",buf.dat);
	}

}

