import java.util.ArrayList;
import java.util.Scanner;
abstract class Animal{
private String name;
private int age;
private double weight;
 int count = 0;
 
Animal(String name,int age , double weight){
    this.name= name;
    this.age=age;
    this.weight = weight;
    count++;
    
}
public void print(){
    System.out.println(name+" "+" "+age+" "+weight);
}
public int getAge(){
    return age;
}
public double getWeight(){
    return weight;
}
public abstract String speak();
}
class Dog extends Animal {
    Dog(String name,int age , double weight){
        super(name,age,weight);
        count++;
    }
    public String speak(){
        return "Dog";
    }
}
class Cat extends Animal {
    Cat(String name,int age , double weight){
        super(name,age,weight);
        count++;
    }
    public String speak(){
        return "Cat";
    }
}

public class ReportDogCat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Dog> dg = new ArrayList<Dog>();
        ArrayList<Cat> ct = new ArrayList<Cat>();
        int countD = 0;int countC = 0;double sumWeightD=0,sumWeightC=0, sumAgeC=0,sumAgeD=0;
        while(true){
            String [] order = scan.nextLine().split(" ");
            if (order.length==1){
                if (order[0].equals("D")){
                    for (int i = 0;i<countD;i++){
                        dg.get(i).print();
                         sumAgeD = sumAgeD+dg.get(i).getAge();
                         sumWeightD = sumWeightD+dg.get(i).getWeight();
                    }System.out.println(countD+" Dogs, A:"+(sumAgeD/countD)+", W:"+sumWeightD/countD);
                    System.out.println("----------");
                }
                if (order[0].equals("C")){
                    for (int i = 0;i<countC;i++){
                        ct.get(i).print();
                        sumAgeC = sumAgeC+ct.get(i).getAge();
                         sumWeightC = sumWeightC+ct.get(i).getWeight();
                    }System.out.println(countC+" Catss, A:"+(sumAgeC/countC)+", W:"+sumWeightC/countC);
                    System.out.println("----------");
                }
                if (order[0].equals("Q")){
                    break;
                }
            }
            else{
                switch(order[3]){
                    case "D" :
                        dg.add(new Dog(order[0],Integer.parseInt(order[1]),Double.parseDouble(order[2])));
                        countD++;
                        break;
                    case "C" :
                        ct.add(new Cat(order[0],Integer.parseInt(order[1]),Double.parseDouble(order[2])));
                        countC++;
                        break;
                }
            }
            
        }
        
        
    }
}
    

