
class Person {

    protected String name;
    protected String idNumber;
    protected String address;

    public Person() {
        this.name = "";
        this.address = "";
        this.idNumber = "";
    }

    public Person(String n) {
        this.name = n;
    }

    public void setName(String name) {
        this.name = name;
        this.address = "";
        this.idNumber = "";
    }

    public String getName() {
        return name;
    }

    public void setAddress(String a) {
        this.address = a;
    }

    public String getAddress() {
        return address;
    }
}

class Employee extends Person {

    private String position;
    private double salary;

    public Employee() {
        this.position = "Worker";
        this.salary = 9000;
    }

    public Employee(String pos, double money) {
        this.position = pos;
        this.salary = money;
    }

    public void promote(String position, double mon) {
        this.position = position;
        this.salary = mon;
    }

    public void printDetail() {
        System.out.printf("%s:%s\n%s = %.1f", name, address, position, salary);
    }
}

class HourlyEmployee extends Person {

    private int hours;
    private double wage;

    public HourlyEmployee(double wage) {
        this.wage = wage;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double totalWage() {
        return hours * wage;
    }

}

public class InheritanceOfPerson {

   public static void main(String[] args){
 Person x = new Person();
x.name = "Swan Patipan";
x.idNumber = "2676354187365";
x.address = "56 Jaktujak Bangkok";
System.out.println(x.getName()+":"+x.getAddress());
x = new Employee();
x.name = "Iti Para";
x.idNumber = "2176872865276";
x.address = "43 Taweewattana Bangkok";
System.out.println(x.getName()+":"+x.getAddress());
 }}