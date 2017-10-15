#include<stdio.h>

struct memory{
    int space;
    int filled;
};

int main(){
    int n,i,k=0,ch,mm,t,index,min;
    printf("enter no of memory spaces");
    scanf("%d",&n);
    struct memory list[n];
    printf("enter each memory size:\n");
    for(i=0;i<n;i++){
        scanf("%d",&list[i].space);
        list[i].filled=0;
        
    }
    while(1){
        printf("enter 0 for exit and 1 allocation");
        scanf("%d",&ch);
        if(ch==1){
            printf("enter memory required");
            scanf("%d",&mm);
            min=1000;
            index=-1;
            for(i=0;i<n;i++){
                if(list[i].space>=mm&&list[i].filled!=1){
                    t = list[i].space-mm;
                    if(t<min){
                        min=t;
                        index=i;
                    }
                }
            }
            if(index!=-1){
                list[index].filled=1;
                printf("\nthe allocated memory is: %d",list[index].space);
            }
            else{printf("memory full or size greater than all the blocks\n");
                break;
            }
        }else{break;}
    }

    return 0;
}