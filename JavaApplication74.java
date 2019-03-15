interface rank {
    String report();
}
class Rent7Day implements rank{
    public String report(){
        return "ยืมได้ 7 วัน ใช้ได้ตลอด";
    }    
}
class Rent7DayTerm implements rank{
    public String report(){
        return "ยืมได้ 7 วัน หรือ ตลอดเทอมก็ได้";
    }
}
class  Rent15Day implements rank{
    public String report(){
        return "ยืมได้ 15 วัน";
    }
}
class CantRent implements rank{
    public String report(){
        return "ยืมไม่ได้ เข้าใช้เฉพาะช่วงสอบ";
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
public class JavaApplication74 {

    public static void main(String[] args) {
        TEACHER t1  = new TEACHER("วิชุดา");
        t1.tellMe();
        t1.setRank(new CantRent());
        t1.tellMe();
        STUDENT s1 = new STUDENT("อาติ่ม");
        s1.tellMe();
    }
    
}
