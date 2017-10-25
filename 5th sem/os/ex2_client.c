#include<stdio.h>
#include<sys/ipc.h>
#include<sys/shm.h>
#include<sys/types.h>
int main(){
	int shmSz = 27;//size of the shared memory required
	int key = 1234;//same as the server program
	char *s,z,*shm;
	int i,shmId;	

	//getting the id of the created the shared memory location
	if((shmId=shmget(key,shmSz,0666))<0){
		printf("maagi");
	}

	//getting the location into a pointer from the memory
	if((shm=shmat(shmId,NULL,0))==(char*)-1){
		printf("samosa");
	}
	
	//printing the data at the memory
	for(s=shm;*s!=NULL;s++){
		putchar(*s);	
	}
	
	//signalling the other program to stop
	*shm = '*';
}
