class PERSON{
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
	PERSON[] p = new PERSON[20];
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
	public void printStatus(String name){
		System.out.println("Register success ! Hello I'm "+name);
	}
}


class CONTROLLER{	//controller
	DB db = new DB();
	DISPLAY dp = new DISPLAY();
	
	public void register(){
		db.addMember("panuwish",777,"nakonprathom");
		dp.printStatus(db.getMember());
	}
}

public class mvc{
	public static void main(String [] args){
		CONTROLLER ctl = new CONTROLLER();
		ctl.register();
	}
}