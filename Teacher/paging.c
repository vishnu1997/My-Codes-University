#include<stdio.h>

//Page Size
int pSize;
//Number of division for the Physical and Virtual Address
int pDiv, vDiv;
//If division is not equal (Fault Tolerance)
int pExtra, vExtra;	

//Gettting Input for Physical Memory and Virtual Memory	
void getInfo(){
	int vMem, pMem;
	printf("Enter total physical memory (in KB): ");
	scanf("%d", &pMem);
	printf("Enter total virtual memory (in KB): ");
	scanf("%d", &vMem);
	printf("Enter page size (in KB): ");
	scanf("%d", &pSize);
	//Dividing into segments	
	pDiv = pMem/pSize;
	//Fault Tolerance
	if(pMem%pSize!=0){
		pExtra = pMem-(pSize*pDiv);
		pDiv++;	
	}
	vDiv = vMem/pSize;
	if(vMem%pSize!=0){
		vExtra = vMem-(pSize*vDiv);
		vDiv++;	
	}
	
}

//***** MAIN ******

int main(){
	int vAddr, pAddr;
	int i, pageNum, frameNum, vMemAdd;
	
	int table[16];					//Used for mapping
	int ch;						
	getInfo();
	//initialising table with -1
	for(i=0; i<vDiv; i++){
		table[i]=-1;
	}
	i=0;
	printf("\n%d \t %d", pDiv, vDiv);	
	
	//Getting page table
	printf("\nEnter the page table\n");
	while(i<pDiv){
		//Which Page number?
		printf("Enter the page number for frame number %d: ", i);
		scanf("%d", &pageNum);
		//if page number is more than number of segments (Fault Tolerance)
		if(pageNum>vDiv){
			printf("\nInvalid choice. Choose Again\n");
		}
		//if segments already has page number (Fault Tolerance)
		else if(table[pageNum]!=-1){
			printf("\nPage already has an active Frame number\n");
		}
		//Without any error? Do This
		else{
			table[pageNum]=i;
			i++;
		}	
	}
	

	//Finding physical Address of given virtual address
	do{
		vMemAdd=0;		
		printf("Enter any virtual address:");
		scanf("%d", &vAddr);
		//Finding page number for the virtual address
		pageNum = vAddr / (pSize*1024);
		//If its n bytes from the base address
		if((vAddr / (pSize*1024))!=0){
			vMemAdd = vAddr - pageNum*pSize*1024;
		}
		//Frame Number
		frameNum = table[pageNum];
		if(frameNum == -1){
			printf("\n******TRAPPED*******\n");
			return 0;
		}
		//Finding Physical address
		pAddr = frameNum*pSize*1024 + vMemAdd;
		printf("\n The physical Address for virtual address %d is %d", vAddr, pAddr);

		//Choice for more findings 		
		printf("\nWant to find one more? 1 for Yes. 0 for No)");
		scanf("%d", &ch);	
	}while(ch==1);
	return 0;
}
