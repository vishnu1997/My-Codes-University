//
//  infixtopost.cpp
//  
//
//  Created by Vishnu Vardhan Reddy on 10/30/16.
//
//

#include <iostream>
using namespace std;
char s[20];
int top=-1;
void push(char c){
    if(top>=19){
    cout<<"stack full";
    }
    else{
        top++;
        s[top]=c;
    }
}
char pop(){
    char d;
    if(top== -1){
    cout<<"stack empyty";
        return 0;
    }
    else{
        d=s[top];
        top--;
        return d;
    }
}
char peek(){
    return s[top];
}

int prior(char c){
    switch(c){
        case '+':
        case '-':
            return 1;
            break;
        case '*':
        case '/':
            return 2;
            break;

        case '^':
            return 3;
            break;
            case '(':
            return 0;
            break;
    }
}
int main(){
    char a[20],p[20],t,ch,d;
    int i,j;
    i=0;
    j=0;
    cout<<"expersiion";
    cin>>a;
    while(a[i]!='\0'){
        t=a[i];
        if(t=='('){
            push(t);
        }
        else if(t==')'){
            ch=pop();
            while(ch!='('){
                p[j]=ch;
                j++;
                ch=pop();
            }
        }
        else if(t=='+'||t=='-'||t=='/'||t=='*'||t=='^'){
            ch=peek();
            while(top!=-1&&prior(a[i])<=prior(ch)){
                d=pop();
                p[j]=d;
                j++;
            }
            push(t);
        }
        else{p[j]=a[i];
            j++;}
      
        i++;
    }
    while(top!=-1){
        p[j]=pop();
        j++;
    }
    cout<<p;
    return 0;
}
