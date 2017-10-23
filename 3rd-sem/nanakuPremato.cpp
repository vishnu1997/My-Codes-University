//
//  nanakuPremato.cpp
//  
//
//  Created by Vishnu Vardhan Reddy on 11/4/16.
//
//

#include <iostream>
#include<math.h>
using namespace std;



int main(){
    int i,n,j,k,a[200];
    k=0;
    cout<<"enter the no of persons";
    cin>>n;
    for(int i=0;i<200;i++){
        a[i]=0;
    }
    int h=0;
    for(int i=0;i<log(n);i++){
        if(h<n-1){

        for(int j=0;j<n;j++){
            //if(h<n-1){
            if(a[j]==0&&k==0){
                k++;
            }
            else{
                if(a[j]==0){
                    k=0;
                    h++;
                }
                a[j]=1;
                
            }
            
        }
            }
    }
    
    for(int i=0;i<n;i++){
        if(a[i]==0){cout<<i+1;}
    }
    return 0;
}
