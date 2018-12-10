#include<stdio.h>
int main(){
	int spacemid,i,j;
	int spacefront=0;
	scanf("%d",&spacemid);
	int travspace=spacemid;
	for(i=spacemid/2;i>0;i--){
		for(j=0;j<spacefront;j++){
			printf(" ");
		}
		printf("*");
		for(j=0;j<travspace;j++){
			printf(" ");
		}
		printf("*");
		spacefront++;
		travspace-=2;
		printf("\n");
	}
	for(i=0;i<=spacefront;i++)printf(" ");
	printf("*\n");
	for(i=spacemid/2;i>0;i--){
		for(j=0;j<spacefront;j++){
			printf(" ");
		}
		printf("*");
		for(j=0;j<travspace;j++){
			printf(" ");
		}
		printf("*");
		spacefront--;
		travspace+=2;
		printf("\n");
	}
	
}
