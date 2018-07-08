import java.util.Scanner;
public class MapMarking1 {

    public static void main(String[] args) {
 Scanner scan = new Scanner(System.in);
 int R = scan.nextInt();
 int C = scan.nextInt();
 int found = 1;
 int[][] map = new int[R+3][C+3];
 boolean[][] isFound = new boolean[R+3][C+3];
 int rPoint = scan.nextInt();
 int cPoint = scan.nextInt();
 isFound[rPoint][cPoint] = true;
 int N = scan.nextInt();
 for (int i=0;i<N;i++){
     switch(scan.nextInt()){
         case 1 :
             if ((cPoint-1)>0)
                 cPoint-=1;
             break;
         case 2 :
              if ((cPoint+1)<=C)
                 cPoint+=1;
             break;
         case 3 :
               if ((rPoint-1)>0)
                 rPoint-=1;
             break;
         case 4 :
               if ((rPoint+1)<=R)
                 rPoint+=1;
     }
     if(!isFound[rPoint][cPoint]){
                     isFound[rPoint][cPoint]=true;
                     found++;
                 }
 }
        System.out.println(rPoint+" "+cPoint);
        System.out.println(found);
    }
    
}
