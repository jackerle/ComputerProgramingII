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
    public void printStatus(){
        System.out.println(name);
        if (type==1)System.out.println("Fan");
        else if (type==2)System.out.println("P1");
        else System.out.println("VIP");
        System.out.println(order + " " + seat);
        System.out.println((status)? "Active" : "Inactive");
            
        
    }
}
public class BusCompany1 {

    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       Bus bus = new Bus(scan.next(),scan.nextInt(),scan.nextInt());
       bus.printStatus();
    }
    
}