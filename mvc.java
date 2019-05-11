class PERSON{	//สร้าง person เพื่อแทนข้อมูลของคนแต่ละคน
	public String name;
	public int id;
	public String address;
	PERSON(String n,int id,String address){
		this.name = n;
		this.id = id;
		this.address = address;
	}
}
class DB{	//model
	PERSON[] p = new PERSON[20]; //นำ person มาเก็บเป็น อาเรย์ เป็นกลุ่มข้อมูล databases
	public int index = 0;
	public void addMember(String n,int id,String address){ 
		p[index] = new PERSON(n,id,address);
		index++;
	}
	public String getMember(){
		return p[index-1].name;
	}
}
class DISPLAY{	//view
	public void printStatus(String name){ //เป็น method ที่แสดงผลอย่างเดียวและจะไม่มีการดึงข้อมูลที่ตัว model
		System.out.println("Register success ! Hello I'm "+name);
	}
}


class CONTROLLER{	//controller
	DB db = new DB();	//สร้าง object ของ model
	DISPLAY dp = new DISPLAY();	//สร้าง object ของ view
	
	public void register(){	//สร้าง feature register
		db.addMember("panuwish",777,"nakonprathom");	//เพิ่มข้อมูลใน database หรือส่วนของ model
		dp.printStatus(db.getMember());	//แสดงข้อความตอบกลับว่า register สำเร็จแล้วผ่าน display โดยส่ง param เป็น string ไปให้แสดง แต่จะไม่ส่งข้อมูลที่เป็น ข้อมูลจริงๆไป
	}
}

public class mvc{
	public static void main(String [] args){
		CONTROLLER ctl = new CONTROLLER();	//สร้าง obj
		ctl.register();	//เรียกใช้ feature register
	}
}