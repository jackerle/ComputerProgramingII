import java.util.Scanner;
interface CAR{  
    void detail();
}
class BMW implements CAR{
    public void detail(){
        System.out.println("This is BMW brand");
    }
}
class HONDA implements CAR{
    public void detail(){
        System.out.println("This is Honda brand");
    }
}
class TOYOTA implements CAR{
    public void detail(){
        System.out.println("This is Toyota brand");
    }
}
class ERROR implements CAR{
    public void detail(){
        System.out.println("Error.Dont match for any brands");
    }
}
class Carfactory{
    public CAR createCar(){
        System.out.println("What brand you want?\n-1)bmw\n-2)honda\n-3)toyota");
        Scanner sc = new Scanner(System.in);
        int brand = sc.nextInt();
        switch(brand){
            case 1:
                return new BMW();
            case 2:
                return new HONDA();
            case 3:
                return new TOYOTA();
            default:
                return new ERROR();
        }
    }
}
public class JavaApplication57 {

    public static void main(String[] args) {
        Carfactory cft = new Carfactory();
        CAR bm1 = cft.createCar();
        bm1.detail();
    }
    
}
