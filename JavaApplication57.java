import java.util.Scanner;
interface CAR{  //สร้าง interface ของ car เป็นต้นแบบ
    void detail();  //เป็นการบอกว่า object car ทุกอันที่ implement ไปจะมี method นี้เสมอ
}
class BMW implements CAR{
    public void detail(){
        System.out.println("This is BMW brand");    //method นี้ของแต่ละ car จะแตกต่างกัน
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
        System.out.println("What brand you want?\n-1)bmw\n-2)honda\n-3)toyota");    //display ข้อความถามว่าจะเอาแแบรนด์ไหน
        Scanner sc = new Scanner(System.in);
        int brand = sc.nextInt();   //รับข้อมูลมาตัวนึง
        switch(brand){  // เช็ค if condition และสร้าง object ตาม input ที่รับมา
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
        Carfactory cft = new Carfactory();  //สร้าง object ของ factory
        CAR bm1 = cft.createCar();  //ใช้ method ของ factory นั้น
        bm1.detail();
    }
    
}
