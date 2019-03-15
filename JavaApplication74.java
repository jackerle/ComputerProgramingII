interface rank {
    String report();
}
class Rent7Day implements rank{
    public String report(){
        return "เป็นนักเรียน ยืมได้ 7 วัน ใช้ได้ตลอด";
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
abstract class member {
    String name;
    rank r;
    public void tellMe(){
        System.out.println(name+":"+r.report());
    }
    public void setRank(rank r){
        this.r = r;
    }
}
class TEACHER extends member{
    TEACHER(String name){
        r = new Rent7DayTerm();
        this.name = name;
    }
}
class STUDENT extends member{
    STUDENT(String name){
        r = new Rent7Day();
        this.name = name;
    }
}
class OUTER extends member{
    OUTER(String name){
        r = new CantRent();
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
        t1.tellMe();
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