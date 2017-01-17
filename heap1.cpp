//
//  heap1.cpp
//  
//
//  Created by Vishnu Vardhan Reddy on 11/2/16.
//
//

#include <iostream>
using namespace std;
int arr[10];


void adjust(int i,int size){
    int left=2*i+1;
    int largest=i;;
    int right=2*i+2;
    if(left<=size&&arr[left]>arr[i]){
        largest=left;
    }else{largest=i;}
    if(right<=size&&arr[largest]<arr[right]){
        largest=right;
    }
   
    if(largest!=i){
        int t=arr[largest];
        arr[largest]=arr[i];
        arr[i]=t;
        adjust(largest,size);
    }
    
}

void heapify(int size){
    int i=(size/2)-1;
    while(i>=0){
        adjust(i,size);
        i--;
    }
}


void heap(int size){
    heapify(size);
    int q=size;
    while(q>=2){
        int t=arr[0];
        arr[0]=arr[q-1];
        arr[q-1]=t;
        q--;
        adjust(0,q);
       
    }

}



int main(){
    int n;
    cout<<"enter no of elmemnts";
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    heap(n);
    for(int i=0;i<n;i++){
        cout<<arr[i];
    }
    return 0;
}
