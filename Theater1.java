import java.util.Scanner;
class Theater {
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
        this.seats = new boolean[canSit+1];
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
}
public class Theater1 {

    public static void main(String[] args) {
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

 String dummy = scan.nextLine();// throw away a new line character
 String title = scan.nextLine();
 if(title.compareTo("-1") == 0)
 t.setTitle(null);
 else
 t.setTitle(title);

 int basePrice = scan.nextInt();
 t.setBasePrice(basePrice);
 t.printInfo();
 }

    }
    

