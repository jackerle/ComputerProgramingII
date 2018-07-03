import java.util.Scanner;
class Bus {
    String name;
    int type;
    int seat;
    int order = 0;
    boolean status = true;
    Bus(String name , int type , int seat){
        this.name = name;
        this.type = type;
        this.seat = seat;
    }
    public void printStats(){
        System.out.println(name);
        if (type==1)System.out.println("Fan");
        else if (type==2)System.out.println("P1");
        else System.out.println("VIP");
        System.out.println(order + " " + seat);
        System.out.println((status)? "Active" : "Inactive");
    }
    boolean reserve (int K ){
        if (K<0||order+K>seat||status == false)return false;
        else {
           order+=K;
           return true;
        }
    }
    void sendToRepair(){
        this.status = false;
    }
    void backToService(){
        this.status = true;
    }
}
public class BusCompany2 {
 public static void main(String[] args) {
 Scanner scan = new Scanner(System.in);
 String id = scan.next();
 int type = scan.nextInt();
 int seats = scan.nextInt();
 Bus b = new Bus(id, type, seats);

 int N = scan.nextInt();
 for(int i = 0; i < N; ++i) {
 int P = scan.nextInt();
 int K = scan.nextInt();
 if(P == 1)
 b.reserve(K);
 else if(P == 2)
 b.sendToRepair();
 else if(P == 3)
 b.backToService();
 b.printStats();
 }
 }
}
