#include<stdio.h>

struct memory{
    int space;
    int filled;
};

int main(){
    int n,i=0,k=0,ch,mm,flag,flag1,flag2;
    printf("enter no of memory spaces");
    scanf("%d",&n);
    struct memory list[n];
    printf("enter each memory size:\n");
    for(i=0;i<n;i++){
        scanf("%d",&list[i].space);
        list[i].filled=0;
        
    }

    flag1=0;
    while(1){
        printf("enter 0 for exit and 1 allocation");
        scanf("%d",&ch);
        if(ch==1){
            printf("enter memory required");
            scanf("%d",&mm);
            flag=-1;                                 //checks if any memory is fit for it or not
            for(i=0;i<n;i++){             
                if(list[i].space>=mm&&list[i].filled!=1){//
                    list[i].filled=1;
                    printf("\nthe allocated memory block is: %d\n",list[i].space);
                    flag = 1;
                    flag1++;
                    break;
                }
             
            }
            
            if(flag==-1){
                printf("memory full or size greater than all the blocks\n");
            }
            if(flag1==n){                               //if all the memory is filled
                printf("all the blocks are filled\n");
                break;
            }
        }else{
            break;                                  //for outer while loop
        }
    }
    return 0;
}