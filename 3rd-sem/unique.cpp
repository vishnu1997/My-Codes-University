#include<iostream>

using namespace std;

int digit(unsigned long long int n){
	int i=0;
	while(n!=0){
	n=n/10;
	i++;
	}
	cout<<i;
	if(i==1){return 0;}
	else{return 1;}
}

int main(){
	unsigned long long int x,y,z,n;
	cin>>x;
	y = 1;
	while(digit(y)){
	while(x != 0){
		n = x%10;
		if(n != 0){
			y = y*n;
		}
		x=x/10;
	}
	x=y;
	}
	
	cout<<endl<<y;


	return 0;
}
