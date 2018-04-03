
class Shape{
    private int px;
    private int py;
    private double area;
    Shape(int px,int py){
        this.px = px;
        this.py = py;
    }
    public void calArea()
        {}
    public void setArea(double area){
        this.area = area;
    }
    public double getArea(){
    return area;
    }
}
class Circle extends Shape{
   private double radius;
   Circle(int px,int py,double radius){
    super(px,py);
    this.radius = radius;
   }
   public void calArea(){
        double area = Math.PI*radius*radius;
        super.setArea(area);
   }
}
   class Rectangle extends Shape{
   private double width,height;
   Rectangle(int px,int py,double width,double height){
    super(px,py);
    this.width = width;
    this.height = height;
   }
   public void calArea(){
        double area = width*height;
        super.setArea(area);
   } 
}
public class Shapes {
    public static void main(String[] args) {
        Circle c1 =new Circle(10,10,3.5);
        c1.calArea();
        System.out.println("area: "+c1.getArea());
        Circle c2 = new Circle(10,10,10);
        c2.calArea();
        System.out.println("area: "+ c2.getArea());
        Rectangle r1 = new Rectangle(3,5,10,10);
        r1.calArea();
        System.out.println("area: "+r1.getArea());
        Rectangle r2 = new Rectangle(8,12,5,5);
        r2.calArea();
        System.out.println("area: "+ r2.getArea());
    }
    
}

