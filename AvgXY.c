#include<stdio.h>
int main(){
int N,i,x,y;    
scanf("%d",&N);         ///รับ N
int arr[N];             ///สร้าง arr ตาม N เพื่อที่จะรับinput ตามโจทย์ N ครั้ง
for(i=0;i<N;i++)scanf("%d",&arr[i]);    ///รับเลขมา N ตัว ใส่ arr ไว้
scanf("%d %d",&x,&y);           ///แล้วก็รับ x กับ y ตามโจทย์
int count=0;                    ///สร้าง count มาเก็บจำนวนครั้งที่เลขอยู่ระหว่าง หรือก็คือคำตอบแรกของโจทย์นั่นเอง
double sum=0;                   ///สร้าง ตัวแปรชนิด double มาเก็บผลรวม (ลองใช้ float แล้วมันไม่พอ)

for(i=0;i<N;i++){               ///หมุนลูป Nครั้งโดยหมุน iไปเรื่อยๆ
    if(arr[i]>=x&&arr[i]<=y){       ///ถ้า เลข arr ที่ตำแหน่ง i มันอยู่ระหว่าง x กับ y
        count++;                //นับ count ขึ้น
        sum+=arr[i];            ///เอามารวมใส่ใน sum
    }
}
double average = sum/count;     ///พอออกจากลูปมาสร้างตัวแปรค่าเฉลี่ยที่เท่ากับผลรวมส่วนด้วยจำนวน(sum/n)
printf("%d\n",count);           ///แสดงผลตัวนับ
if(count==0)printf("none");     ///ถ้าตัวนับเป็น 0 คือไม่มีอะไรให้ปริ้นท์ none
else printf("%.2lf",average);   ///ถ้ามีก็ปริ้นท์ค่าเฉลี่ย
}

