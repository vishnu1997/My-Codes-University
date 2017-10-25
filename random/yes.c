#include <stdio.h>
typedef struct marks{
    
	int a:1;
    
	int b:2;

};

int main(void) {
    
    int a=2;
    a=a++ + ~++a;
    printf("%d",a);


    
	return 0;

}