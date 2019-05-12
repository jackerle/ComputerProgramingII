interface learning{
    double getPercent();
}
class Lecture implements learning{
    public double getPercent(){
        double p = 0.05;
        return p;
    }
}
class Reading implements learning{
    public double getPercent(){
        return 0.1;
    }
}
class Audiovisual implements learning{
    public double getPercent(){
        return 0.2;
    }
}
class Demonstratio implements learning{
    public double getPercent(){
        return 0.3;
    }
}
class Discussion_group implements learning{
    public double getPercent(){
        return 0.5;
    }
}
class Practice_by_doing implements learning{
    public double getPercent(){
        return 0.75;
    }
}
class Facilitate implements learning{
    public double getPercent(){
        return 0.9;
    }       
}
interface TEACHER{
    double getp1();
    double getp2();
    double getp3();
    double getp4();
    double getp5();
}
class k implements TEACHER{
     double p1=20,p2=20,p3=20,p4=20,p5=20;
    k(learning l){
       
        this.p1=this.p1*l.getPercent();
        this.p2=this.p2*l.getPercent();
        this.p3=this.p3*l.getPercent();
        this.p4=this.p4*l.getPercent();
        this.p5=this.p5*l.getPercent();
    }
    public double getp1(){
        return p1;
    }
    public double getp2(){
        return p2;
    }
    public double getp3(){
        return p3;
    }
    public double getp4(){
        return p4;
    }
    public double getp5(){
        return p5;
    }
}
class o implements TEACHER{
    double p1=10,p2=10,p3=10,p4=20,p5=50;
   o(learning l){
        this.p1=this.p1*l.getPercent();
        this.p2=this.p2*l.getPercent();
        this.p3=this.p3*l.getPercent();
        this.p4=this.p4*l.getPercent();
        this.p5=this.p5*l.getPercent();
    }
    public double getp1(){
        return p1;
    }
    public double getp2(){
        return p2;
    }
    public double getp3(){
        return p3;
    }
    public double getp4(){
        return p4;
    }
    public double getp5(){
        return p5;
    }
}
class STUDENT{
    String name;
    double score1;
    double score2;
    double score3;
    double score4;
    double score5;
    double total;
    STUDENT(){

    }
    STUDENT(STUDENT s){
        this.name = s.name;
        this.score1 = s.score1;
        this.score2 = s.score2;
        this.score3 = s.score3;
        this.score4 = s.score4;
        this.score5 = s.score5;
        calcTotal();
    }
    STUDENT setName(String n){
        this.name = n;
        return this;
    }
    STUDENT setScore1(TEACHER t){
        this.score1 = t.getp1();
        return this;
    }
    STUDENT setScore2(TEACHER t){
        this.score2 = t.getp2();
        return this;
    }
    STUDENT setScore3(TEACHER t){
        this.score3 = t.getp3();
        return this;
    }
    STUDENT setScore4(TEACHER t){
        this.score4 = t.getp4();
        return this;
    }
    STUDENT setScore5(TEACHER t){
        this.score5 = t.getp5();
        return this;
    }
    STUDENT create(){
        return new STUDENT(this);
    }
    void calcTotal(){
        this.total = this.score1+this.score2+this.score3+this.score4+this.score5;
    }
    double getTotal (){
        return this.total;
    }
    void printStatus(){
        System.out.println("ชื่อ :"+this.name+" คะแนน :"+(int)this.getTotal());
    }
}

public class finaltest {
    public static void main(String [] args){
        STUDENT korn = new STUDENT()
                .setName("กรกนก")
                .setScore1(new k(new Lecture()))
                .setScore2(new k(new Lecture()))
                .setScore3(new k(new Lecture()))
                .setScore4(new k(new Lecture()))
                .setScore5(new k(new Lecture()))
                .create();
        STUDENT wishuda = new STUDENT()
                .setName("วิชุดา")
                .setScore1(new k(new Reading()))
                .setScore2(new k(new Discussion_group()))
                .setScore3(new o(new Demonstratio()))
                .setScore4(new o(new Demonstratio()))
                .setScore5(new o(new Demonstratio()))
                .create();
        STUDENT marisa = new STUDENT()
                .setName("มาริสา")
                .setScore1(new o(new Facilitate()))
                .setScore2(new k(new Practice_by_doing()))
                .setScore3(new o(new Practice_by_doing()))
                .setScore4(new k(new Practice_by_doing()))
                .setScore5(new o(new Practice_by_doing()))
                .create();
        STUDENT srisuda = new STUDENT()
                .setName("ศรีสุดา")
                .setScore1(new k(new Audiovisual()))
                .setScore2(new o(new Audiovisual()))
                .setScore3(new k(new Demonstratio()))
                .setScore4(new o(new Reading()))
                .setScore5(new o(new Facilitate()))
                .create();
        korn.printStatus();
        wishuda.printStatus();
        marisa.printStatus();
        srisuda.printStatus();
        
    }
}