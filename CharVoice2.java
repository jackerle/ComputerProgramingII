import java.util.Scanner;
class Character{
    String[] sentense;
    int count=0;
    Character(String[] sentense){
        this.sentense=sentense;
    }
    void speak(){
        if(count>=sentense.length-1)count=0;
        System.out.println(sentense[count]);
        count++;
    }
    
}
public class CharVoice2 {

    public static void main(String[] args) {
 Scanner scan = new Scanner(System.in);
 final int N = scan.nextInt();
 Character[] chr = new Character[N+1];
 for(int i=0;i<N;i++){
     int n = scan.nextInt();
     scan.nextLine(); 
     String[] msg = new String[n+1];
     for(int o=0;o<n;o++){
         msg[o] = scan.nextLine();
     }
     chr[i] = new Character(msg);
     
 }
   int Num = scan.nextInt();
   for(int i=0;i<Num;i++){
       int inp = scan.nextInt();
       chr[inp-1].speak();
   }
}
}