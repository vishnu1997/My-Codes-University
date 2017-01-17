//
//  string.cpp
//  
//
//  Created by Vishnu Vardhan Reddy on 10/21/16.
//
//

#include <iostream>
#include<string>
#include<cstring>
using namespace std;
int main(){
    char ch[]="maggi amama";
    int i,j;
    i=0;
    j=0;
    string s,s1[10];
    cout<<"    4      ";
    while(ch[i]!='\0'){
        if(ch[i]!=' '){
        s=ch[i];
        s1[j]=s1[j]+s;
            cout<<s;}
        else{j++;}
        i++;
    }
    cout<<endl;
    cout<<s1[0]<<s1[1];
   /* while(ch[i]!='\0'){
        if(ch[i]!=' '){
            cout<<"    3      ";
            s=ch[i];
            s1[j]=s1[j]+s;
            i++;
        }
        else{
            j++;
        }
    }*/
    //cout<<s1[1];
    
    return 0;
}
