#include<stdio.h>
int main(){
int N,i,x,y;
scanf("%d",&N);
int arr[N];
for(i=0;i<N;i++)scanf("%d",&arr[i]);
scanf("%d %d",&x,&y);
int count=0;
double sum=0;

for(i=0;i<N;i++){
    if(arr[i]>=x&&arr[i]<=y){
        count++;
        sum+=arr[i];
    }
}
double average = sum/count;
printf("%d\n",count);
if(count==0)printf("none");
else printf("%.2lf",average);
}

