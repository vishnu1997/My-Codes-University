#include<stdio.h>
void init(int a[],int n){
	int i;
	for(i=n;i<10;i++){
		a[i]=0;
	}
}

void pri(int a[],int n){
	int i;
	for(i=0;i<n;i++){
		printf("values are  %d::::%d\n",i,a[i]);
	}
}

void circ(int a[],int b[],int y[],int n3){
    int i=0;
    int j=0;
    int k=0;
    for(i=0;i<n3;i++){
        y[i]=0;
        for(j=0;j<n3;j++){
            k=i-j;
            if(k<0)
            k+=n3;
            y[i]+=a[j]*b[k];
        }
    }
}

int main(){
	int x[10],h1[10],h2[10],y1[10],y2[10],y[10],y3[10],y4[10];
	int i,j;
	int n1,n2,n3,n4,n5,n6;
	printf("enter length of 1st sequence");
	scanf("%d",&n1);
	for(i=0;i<n1;i++){
		scanf("%d",&x[i]);
	}
	printf("enter length of 2nd sequence");
	scanf("%d",&n2);
	for(i=0;i<n2;i++){
		scanf("%d",&h1[i]);
	}
    init(x,n1);
    init(h1,n2);
    init(y,0);
    if(n1>n2)
    n3=n1;
    else
    n3=n2;
    circ(x,h1,y,n3);
    pri(y,8);
}