#include<stdio.h>
#include<math.h>
#define PI 3.1415926535897932384
void init(double a[],int n){
	int i;
	for(i=n;i<10;i++){
		a[i]=0;
	}
}

void pri(double a[],int n){
	int i;
	for(i=0;i<n;i++){
		printf("values are  %d::::%lf\n",i,a[i]);
	}
}

int main(){
    int i,j,n;
    double x[10],y1[10],y2[10],y3[10],y4[10];
    printf("enter the length of sequence");
    scanf("%d",&n);
    printf("enter the sequence");
    for(i=0;i<n;i++){
        scanf("%lf",&x[i]);
    }
    init(y1,0);
    init(y2,0);
    for(i=0;i<n;i++){
        for(j=0;j<n;j++){
            y1[i] += x[j]*cos(2*PI*(i)*(j)/n);
            y2[i] += x[j]*(-sin(2*PI*(i)*(j)/n));
        }
    }
    init(y3,0);
    init(y4,0);
    for(i=0;i<n;i++){
        
        for(j=0;j<n;j++){
            y3[i] += y1[j]*cos(2*PI*(i)*(j)/n);
            y3[i] -= y2[j]*(sin(2*PI*(i)*(j)/n));
            
        }
        y3[i]/=n;
    }

    pri(y3,8);
    pri(y4,8);
}