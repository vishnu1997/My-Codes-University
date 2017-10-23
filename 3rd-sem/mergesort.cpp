//
//  mergesort.cpp
//  
//
//  Created by Vishnu Vardhan Reddy on 11/1/16.
//
//

#include <iostream>
using namespace std;
int a[10];
void merge(int low,int mid,int high){
    int i=low;
    int t,temp[10];
    int j=mid+1;
    int h=low;
    t=0;
    while(i<=mid&&j<=high){
        if(a[i]<=a[j])
        {
            temp[h]=a[i];
            i++;
        }
        else{
            temp[h]=a[j];
            j++;
        }
        h++;
    }
    if(i>mid){
        while(j<=high){
            temp[h]=a[j];
            j++;
            h++;
        }
    }else{
        while(i<=mid){
            temp[h]=a[i];
            i++;
            h++;
        }
    }
    i=low;
    while(i<=high){
        a[i]=temp[i];
        i++;
    }
    
}



void mergesort(int low,int high){
    int mid=(low+high)/2;
    if(low<high){
        mergesort(low,mid);
        mergesort(mid+1,high);
        merge(low,mid,high);
    }
}
int main(){
    int n,low,high;
    cout<<"enter the no of elemnts";
    cin>>n;
    high=n-1;
    low=0;
    cout<<"enter data";
    for(int i=0;i<n;i++){
        cin>>a[i];
    }


    mergesort(low,high);
    for(int i=0;i<n;i++){
        cout<<a[i];
    }
    return 0;
    
}
