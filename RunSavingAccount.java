//package runsavingaccount;
import java.util.Scanner;
class SavingAccount{
    public String accountNumber;
    private String accountName;
    private double amount;
    SavingAccount(String numb,String name){
        accountName = name;
        accountNumber = numb;
    }
    public void changeName(String name){
        accountName = name;
    }
    public void deposit(double amount){
        this.amount+=amount;
    }
    public void withdraw(double amount){
        if(this.amount<=amount){
            System.out.println("AMOUNT IN ACCOUT $"+amount+". PLEASE TRY AGAIN.");
        }
        else{
            this.amount-=amount;
        }
    }
    public void display(){
        System.out.println("ACCOUNT NUMBER:"+accountNumber);
        System.out.println("ACCOUNT NAME:"+accountName);
        System.out.println("AMOUNT:$"+amount+0);
    }
}
public class RunSavingAccount {
    public static void main(String[] args) {
        SavingAccount g = new SavingAccount("0-000-000","");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<=n;i++){
            String st = in.nextLine();
            String[] str = st.split(" ");
            if(str[0].equalsIgnoreCase("A")){
               g = new SavingAccount(str[1],str[2]);
            }
            else if(str[0].equalsIgnoreCase("C")){
               g.changeName(str[1]);
            }
            else if(str[0].equalsIgnoreCase("D")){
               g.deposit(Double.parseDouble(str[1]));
            }
            else if(str[0].equalsIgnoreCase("W")){
               g.withdraw(Double.parseDouble(str[1]));
            }
            else if(str[0].equalsIgnoreCase("P")){
               g.display();
            }
        }
    }
    
}