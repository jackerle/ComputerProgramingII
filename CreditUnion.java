import java.util.Scanner;
import java.util.ArrayList;
class SavingAccount{
    public String accountNumber;
    private String accountName;
    private double amount;
    SavingAccount(String numb ,String name){
        this.accountNumber = numb;
        this.accountName = name;
        
    }
    public void changeName(String name){
        this.accountName = name;
    }
    public void deposit(double amount){
        this.amount = this.amount+amount;
    }
    public void withdraw(double amount){
        if (amount>this.amount){
            System.out.println("AMOUNT IN ACCOUT $"+this.amount+". PLEASE TRY" +
" AGAIN.");
        }
        else this.amount = this.amount-amount;
    }
    public void display(){
        System.out.println("ACCOUNT NUMBER:"+accountNumber+"\n" +
"ACCOUNT NAME:"+accountName);
        System.out.printf("AMOUNT:$%.2f\n",amount);
    }
}
public class CreditUnion {

    public static void main(String[] args) {
        boolean isAccount =false;
        Scanner scan = new Scanner(System.in);
        ArrayList <SavingAccount> sa = new ArrayList<SavingAccount>();
        int N = scan.nextInt();
        for (int i = 0 ;i < N ; i++){
            String command = scan.next();
            String inp = scan.next();
            switch(command){
                case "A" :
                    sa.add(new SavingAccount(inp,scan.next()));
                    isAccount = true;
                    break;
                case "C" :
                    String inpCname = scan.next();
                    for (int o = 0 ; o<sa.size();o++){
                        if (sa.get(o).accountNumber.equals(inp)){
                            sa.get(o).changeName(inpCname);
                            isAccount = true;
                        }
                    }
                    break;
                case "D" :
                    double inpDnum = scan.nextDouble();
                    for (int o = 0;o<sa.size();o++){
                        if (sa.get(o).accountNumber.equals(inp)){
                            sa.get(o).deposit(inpDnum);
                            isAccount = true;
                        }
                    }
                    break;
                case "W" :
                    double inpWnum = scan.nextDouble();
                    for (int o = 0;o < sa.size();o++){
                        if (sa.get(o).accountNumber.equals(inp)){
                            sa.get(o).withdraw(inpWnum);
                            isAccount = true;
                        }
                    }
                    break;
                case "P" :
                    for (int o = 0;o<sa.size();o++){
                        if (sa.get(o).accountNumber.equals(inp)){
                            sa.get(o).display();
                            isAccount = true;
                        }
                    }
            }
            if (!isAccount)System.out.println("ACCOUNT NUMBER "+inp+" IS NOT FOUND.");
            isAccount = false;
        }
    }
    
}
