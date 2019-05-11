interface rank {
    String report();    //สร้าง method ที่ทุก class ที่ implement คลาสนี้ไปจะมี
}
class Rent7Day implements rank{ //implement มาจาก rank 
    public String report(){ //จะมี method report เสมอ
        return "เป็นนักเรียน ยืมได้ 7 วัน ใช้ได้ตลอด";  //ส่วนนี้จะต่างกันไปในแต่ละ class
    }    
}
class Rent7DayTerm implements rank{
    public String report(){
        return "เป็นครู ยืมได้ 7 วัน หรือ ตลอดเทอมก็ได้";
    }
}
class  Rent15Day implements rank{
    public String report(){
        return "เป็นพนักงาน ยืมได้ 15 วัน";
    }
}
class CantRent implements rank{
    public String report(){
        return "เป็นคนนอก ยืมไม่ได้ เข้าใช้เฉพาะช่วงสอบ";
    }
}
abstract class member { //สร้างคลาส member ผู้ยืมขึ้นมา
    String name;    //ชื่อของคนยืม
    rank r; //type ยศของคนยืม
    public void tellMe(){   //method ที่เอาไว้บอกชื่อ และยศ
        System.out.println(name+":"+r.report());
    }
    public void setRank(rank r){ //method แต่งตั้งยศใหม่
        this.r = r;
    }
}
class TEACHER extends member{   //สืบทอดมาจาก member 
    TEACHER(String name){
        r = new Rent7DayTerm(); //ส่วนนี้คือส่วนที่กำหนดให้ครูมียศยืมได้ 7 วัน หรือทั้งเทอม คือการกำหนด r นั่นเอง
        this.name = name;
    }
}
class STUDENT extends member{
    STUDENT(String name){
        r = new Rent7Day(); //ส่วนนี้คือการกำหนดยศให้ยืมได้ 7 วันอย่างเดียว
        this.name = name;
    }
}
class OUTER extends member{
    OUTER(String name){
        r = new CantRent(); //จะต่างกันไปในแต่ละคลาสของผู้ยืม
        this.name = name;
    }
}
class AUTHORITY extends member{

    public AUTHORITY(String name) {
        this.name = name;
        r= new Rent15Day();
    }
    
}
public class JavaApplication74 {

    public static void main(String[] args) {
        member t1  = new TEACHER("วิชุดา");
        t1.tellMe();    //จะแสดงผลว่า ยืมได้ 7 วันหรือทั้งเทอมออกมา
        t1.setRank(new CantRent());
        t1.tellMe();
        member s1 = new STUDENT("อาติ่ม");
        s1.tellMe();
        member o1 = new OUTER("อากู๋");
        o1.tellMe();
        member a1 = new AUTHORITY("วีรเดช");
        a1.tellMe();
    }
    
}
