import java.util.Scanner;
class Theater{
     boolean can3D;
    boolean isRich;
    int canSit;
    boolean[] seats;
    String title="";
    int basePrice=0;
    Theater(boolean can3D,boolean isRich,int canSit){
        this.can3D = can3D;
        this.isRich = isRich;
        this.canSit = canSit;
        this.seats = new boolean[canSit+2];
    }
    public void setTitle(String name){
        if(name==null||name.length()==0){
            System.out.println("invalid title");
        }
        else {
            this.title = name;
        }
    }
    public void setBasePrice(int basePrice){
        if(basePrice<=0)System.out.println("invalid price");
        else {this.basePrice=basePrice;}
    }
    public void printInfo(){
        if(can3D)System.out.println("3D");
        else System.out.println("No 3D");
        if (isRich)System.out.println("Luxury");
        else System.out.println("Standard");
        System.out.println(seats.length-1);
       if(title.compareTo("")==0)System.out.println("title is not set");
        else System.out.println(title);
        if(basePrice==0)System.out.println("price is not set");
        else System.out.println(basePrice);
    }
    public int reserveOne(int seatNumber) {
        if(seatNumber<=0||seatNumber>canSit||seats[seatNumber]){
            System.out.println("sorry");
            return -1;
        }
        else {
            seats[seatNumber]=true;
            return basePrice;}
    }
    public int  reserveMultiple(int numSeats, int seatNumber){
        if((seatNumber+numSeats)-1>canSit||seatNumber<=0){
            System.out.println("sorry");
            return -1;
        }
        for(int i=seatNumber;i<numSeats+seatNumber;i++){
                if(seats[i]){
                    System.out.println("sorry");
                    return -1;
                }
            }
        for(int i=seatNumber;i<numSeats+seatNumber;i++){
                seats[i]=true;
            }
        return basePrice*numSeats;
    }
    
}
public class Theater2 {
    public static void main(String[] args) {
        // TODO code application logic here
 Scanner scan = new Scanner(System.in);
 int threeD1 = scan.nextInt();
 int luxury1 = scan.nextInt();
 int numSeats = scan.nextInt();
 boolean threeD = false;
 boolean luxury = false;
 if(threeD1 == 1)
 threeD = true;
 if(luxury1 == 1)
 luxury = true;
 Theater t = new Theater(threeD, luxury, numSeats);

 String dummy = scan.nextLine(); // throw away new line character
 String title = scan.nextLine();
 t.setTitle(title);

 int basePrice = scan.nextInt();
 t.setBasePrice(basePrice);

 int N = scan.nextInt();
 for(int i = 0; i < N; ++i) {
 int numberOfSeats = scan.nextInt();
 int seatNumber = scan.nextInt();
 int totalPrice;
 if(numberOfSeats == 1)
 totalPrice = t.reserveOne(seatNumber);
 else
 totalPrice = t.reserveMultiple(numberOfSeats, seatNumber);
 if(totalPrice > 0)
 System.out.println(totalPrice);
 }

 t.printInfo();
 }

    }
    

