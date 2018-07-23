import java.util.Scanner;
class Character{
    String[] sentense;
    int count=0;
    Character(String[] sentense){
        this.sentense=sentense;
    }
    void speak(){
        if(count>=sentense.length)count=0;
        System.out.println(sentense[count]);
        count++;
    }
    
}


public class CharVoice1 {
    public static void main(String[] args) {
 Scanner scan = new Scanner(System.in);
 final int N = scan.nextInt();
 String[] msg = new String[N];
 scan.nextLine(); // Skip end-line char
 for(int i = 0; i < N; ++i) {
 msg[i] = scan.nextLine();
 }
 Character chr = new Character(msg);
 int n = scan.nextInt();
 for(int i=0;i<n;i++){
     chr.speak();
 }
 // Enter your code here
}

}
