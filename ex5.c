#include<stdio.h>
#include<sys/types.h>
#include<pthread.h>
#include<unistd.h>
#include<semaphore.h>
//#include<stdlib.h>


int rear=0;
int front=0;
int a[5];

sem_t mutex;
sem_t full;
sem_t empty;


int item_produce(){
	static int a = 0;
	return a++;
}

void insert_Item(int item){
	a[rear]=item;
	rear +=1;
	rear %=5;
}

int remove_item(){
	int x = a[front];
	front+=1;
	front%=5;
	return x;
}

void *producer(void *i){int item;static int ix=0;
	int in=(int)i;
	while(1){ix++;sleep(1);
		item = item_produce();
		sem_wait(&empty);
		sem_wait(&mutex);
		insert_Item(item);
		printf("\nproducer puts %d :::%d",in,item);
		sem_post(&mutex);
		sem_post(&full);
	}
	//getchar();
	//exit(0);
}

void *consumer(void *i){int item;static int ix=0;
	int in=(int)i;	
	while(1){ix++;
		sleep(1);
		sem_wait(&full);
		sem_wait(&mutex);
		item=remove_item();
		printf("\nconsumer take %d :::%d",in,item);
		sem_post(&mutex);
		sem_post(&empty);
	}	

}

void main(){
	int i;
	pthread_attr_t *attr = NULL;
	pthread_t p_tid[5];
	pthread_t c_tid[5];
	sem_init(&mutex,0,1);
	sem_init(&empty,0,5);
	sem_init(&full,0,0);
	for(i=0;i<5;i++){
	pthread_create(&p_tid[i],attr,producer,(void*)i);
	pthread_create(&c_tid[i],attr,consumer,(void*)i);
   
    }
	//printf("\n i value is %d",i);
	pthread_join(p_tid[i],NULL);
	pthread_join(c_tid[i],NULL);
}
