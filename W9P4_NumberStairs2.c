#include<stdio.h>
int main(){
	int arr[501];
	int count=0,i,j;
	while(1){
		int input;
		scanf("%d",&input);
		if(input<0||input>=10)break;
		else{
			arr[count]=input;
		}
		count++;
	}
	int space = count-1;
	int digit = 1;
	for(i=0;i<count;i++){
		for(j=0;j<space;j++)printf(" ");
		for(j=0;j<digit;j++)printf("%d",arr[i]);
		printf("\n");
		space--;
		digit++;
	}
}
