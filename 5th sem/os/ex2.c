/* In this program we are creating a shared memory and writing data at that memory
  and waiting for other programs to receive the data  
*/

#include<stdio.h>
#include<sys/ipc.h>//for shmget
#include<sys/shm.h>//for shmget
#include<sys/types.h>//for shmat
int main(){
	int shmId;
	int shmSz = 27;//size of the shared memory required
	int key = 1234;//can be any value
	char *s,z,*shm;

	/*shmget creates shared segment memory and returns id of it if successful,
	IPC_CREAT is used when creating shared memory*/	
	if((shmId=shmget(key,shmSz,IPC_CREAT|0666))<0){
		printf("maagi");
	}

	/*shmat returns the address of the shared segment created*/
	if((shm=shmat(shmId,NULL,0))==(char*)-1){
		printf("samosa");
	}
	
	/*writing data at the memory*/
	s = shm;
	for(z='a';z<='z';z++){
		*s++=z;	
	}

	/*waiting for the client process to complete getting all the data*/
	while(*shm!='*'){
		sleep(1);	
	}
}
