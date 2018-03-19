#include<iostream>
#include<string.h>
using namespace std;

int main(){
    char* s1 = new char[1];
    char* s2 = new char[20];
    strcpy(s1,"abc");
    void *p;
    cout<<"--"<<p;
    //cout<<s1;
    strcpy(s1,s2);
    //cout<<"ere";
    cout<<s1;
    delete []s1;
    cout<<s1;
    s2=NULL;
    //cout<<s2;


}