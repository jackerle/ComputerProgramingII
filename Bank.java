class Customer{
    private String name;
    private String surname;
    private float principle;
    private float interest;
    private float rate=5;
    private float amount;
    private int year = 1;
    Customer(){

    }
    Customer(String name,String surname){
        this.name=name;
        this.surname=surname;
    }
    Customer(String n,String sn,int principle){
        this.name=n;
        this.surname=sn;
        this.principle=principle;
    }
    void plusMoney(){
        //???
    }
    void computeInterest(){
        this.interest = (this.rate/100)*principle;
        amount = principle+interest;
        System.out.println("year "+year+"\nชื่อ "+this.name+" นามสกุล "+surname+" เงินต้น "+this.principle+" เงินต้นรวมดอกเบี้ย "+this.amount);
        this.principle = amount;
        this.year++;
    }
}
public class Bank{
    public static void main(String args[]){
        Customer cust1 = new Customer("นายเอฟ","เรียนไม่จบ",1000);
        Customer cust2 = new Customer("นายเอ","ก็เรียนไม่จบ",1000);
        Customer cust3 = new Customer("นายบี","ก็คงเรียนไม่จบ",1000);
        cust1.computeInterest();

    }

}