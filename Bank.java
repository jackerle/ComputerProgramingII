import java.util.*;
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
        computeInterest();
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
String getName(){
        return this.name;
    }
    void setPrin(float p){
        this.principle = p;
        System.out.println("Now principle is "+p);
    }

    public float getPrinciple() {
        return principle;
    }

    public float getInterest() {
        return interest;
    }
    
}
class DB{
    ArrayList<Customer> DBLis = new ArrayList<Customer>();
    void add(String n,String sn,int principle){
        DBLis.add(new Customer(n,sn,principle));
    }
    void delete(String name){
        for(int i=0;i<DBLis.size();i++){
            if(DBLis.get(i).getName().equals(name)){
                DBLis.remove(i);
                System.out.println("Now number of customer is "+DBLis.size());
            }
        }
    }
    void editPrinciple(String name,float p){
        for(int i=0;i<DBLis.size();i++){
            if(DBLis.get(i).getName().equals(name)){
                DBLis.get(i).setPrin(p);
            }
        }
    }
    void totalDepos(){
        float sum=0;
        for(int i=0;i<DBLis.size();i++){
            sum+=DBLis.get(i).getPrinciple();
        }
        System.out.println("Total is "+sum);
    }
    void show(){
        for(int i=0;i<DBLis.size();i++){
            System.out.println("Name "+DBLis.get(i).getName()+" เงินทั้งหมด "+DBLis.get(i).getPrinciple()+" ดอกเบี้ยทั้งปี "+DBLis.get(i).getInterest());
        }
    }
}
public class Bank{
    public static void main(String args[]){
        DB db = new DB();
        db.add("นายเอฟ", "เรียนไม่จบ", 1000);
        db.add("นายเอ","เรียนไม่จบ",300000);
        db.add("นายบี", "ก็ยังเรียนไม่จบ", 1000000);
        db.show();
        System.out.println("----------------deleted test---------------");
        db.delete("นายเอฟ");
        db.show();
        System.out.println("--------------------------------------------");

    }

}