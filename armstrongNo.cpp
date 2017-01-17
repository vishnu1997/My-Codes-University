//
//  armstrongNo.cpp
//  
//
//  Created by Vishnu Vardhan Reddy on 11/19/16.
//
//

#include <iostream>
#include<math.h>
#include<cmath>
using namespace std;

int main(){
    int r,n,i,t;
    i=0;
    cout<<"enter";
    cin>>n;
    //cout<<n/10;
    t=0;
    while(n!=0){
        int j=n%10;
        t = j+(pow(10,1)*t);
        n=n/10;
        i++;
    }
    cout<<t;
    return 0;
}

