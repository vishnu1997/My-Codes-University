#define N  8
#include<stdio.h>
#include<unistd.h>

int page[N];
int main()
{
 int ch,las,pas,psz,map,off,mapadd,i,j,k;
printf("Enter logical Address space\n");
scanf("%d",&las);
printf("Enter physical Address space\n");
scanf("%d",&pas);
printf("Enter page size");
scanf("%d",&psz);
int n=las/psz;
printf("No of pages in page table %d\n",n);
int pgtbl[n];
for(i=0;i<n;i++)
{
printf("enter the page %d frame in page table entry\n",i);
scanf("%d",&pgtbl[i]);
}
do
{
printf("enter the logical address to be replaced\n");
scanf("%d",&map);
k=map/psz;
off=map%psz;
mapadd=(pgtbl[k]*psz)+off;
if(mapadd>pas)
printf("Logical address space not within the range");
else
printf("The mapped physical address space is %d",mapadd);
printf("press 1 to continue to map other logical adress");
scanf("%d",&ch);
}while(ch==1);
}


