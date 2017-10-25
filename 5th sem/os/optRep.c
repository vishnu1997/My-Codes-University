#include<stdio.h>

int search(int a[],int x,int i,int n){
	int j;	
	for(j=i;j<n;j++){
		if(a[j]==x){return j;}
	}
return 1000;

}

int main(){
	int n,nfr,i,j,k,in;
	int pf=0;											//page fault counter
	printf("enter the no .of frames");
	scanf("%d",&nfr);
	int mm[nfr];										//frame array
	int max[nfr];
	printf("enter the no.of references");
	scanf("%d",&n);
	int ar[n];											//sequence 
	printf("enter the sequence");
	for(i=0;i<n;i++){
		scanf("%d",&ar[i]);
	}
	for(i=0;i<nfr;i++){
		mm[i]=-1;
	}
	for(i=0;i<n;i++){
		// if(i<nfr){         				uncomment these lines are if first pages are consider 
		// mm[i]=ar[i];						to cause fault or not
		// }else{
			if(search(mm,ar[i],0,nfr)==1000){			//already present in frames?
				pf++;
				for(j=0;j<nfr;j++){				
					max[j]=search(ar,mm[j],i+1,n);		//find when the pages in frame would be next called
				}
				k=-1;in = -1;
				for(j=0;j<nfr;j++){				//search which would be not used next
					if(k<max[j]){
						k=max[j];in=j;
					}
				}
				mm[in]=ar[i];
			}
		//}
	}
	
	printf("the page falults re%d \n",pf);	
	return 0;
}
