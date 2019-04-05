import java.util.ArrayList;
import java.util.Scanner;
class User{
    private String userId;
    private int money;
    private int bestScore;
    private String password;
    private String email;
    private String address;
    User(){
        
    }
    User(User u){
        this.userId = u.userId;
        this.password = u.password;
        this.address = u.address;
        this.money = u.money;
        this.email = u.email;
    }
    public User userId(String id){
        System.out.println("id confirmed!");
        this.userId = id;
        return this;
    }
    public User money(int m){
        System.out.println("money confirmed!");
        this.money = m;
        return this;
    }
    public User password(String p){
        System.out.println("password confirmed!");
        this.password = p;
        return this;
    }
    public User email(String email){
        System.out.println("email confirmed!");
        this.email =email;
        return this;
    }
    public User address(String a){
        System.out.println("address confirmed!");
        this.address = a;
        return this;
    }
    public User build(){
        return new User(this);
    }
    public String getID(){
        return this.userId;
    }
    public String getPass(){
        return this.password;
    }
    public String getAddress(){
        return this.address;
    }
    
    
}
class DB{
    ArrayList<User> users = new ArrayList<>();
    DB(){
        //test
       /* User n = new User()
            .userId("jackerle")
            .email("zeustololisis@gmail.com")
            .password("19114198")
            .address("Hello ")
            .money(1000000)
            .build();
        users.add(n);*/
    }
    public void addUser(User u){
        users.add(u);
        System.out.println("registered success!\nYour id is:"+u.getID()+"\n---------------------------------");
    }
    public User authenricate(String id,String pass){
        if(!users.isEmpty()){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getID().equals(id)){
                  System.out.println(users.get(i).getID());
                if(users.get(i).getPass().equals(pass)){
                    System.out.println("Login Succes! :"+users.get(i).getID()+"\n-------------------------------");
                    return users.get(i);
                }
                else{
                    System.out.println("password not match!");
                    return null;
                }
            }
         
        }
        }
        System.out.println("ID doesn't exist!");
        return null;
    }
    public int length(){
        int n = users.size();
        return n;
    }
    
}
class Admin{
    
}
class Server{
    private User session = null;
    public Server() {
    System.out.println("welcome to game server!!!");
    this.index();
    }
    DB db = new DB();
    public void index(){
        if(session==null){
        System.out.println("what do you want!?\n1.register\n2.login");
        switch(new Scanner(System.in).nextInt()){
            case 1:
                this.register();
                break;
            case 2:
                this.login();
                break;
            default :
                break;
        }
    }
        else{
        System.out.println("what do you want!?\n1.viewprofile\n2.logout");
        switch(new Scanner(System.in).nextInt()){
            case 1:
                viewProfile();
                break;
            case 2:
                this.logout();
                break;
            default :
                break;
        }
        }
    }
    public void register(){
        System.out.println("fill your id->email->password->address->money for register!!");
         User n = new User()
            .userId(new Scanner(System.in).nextLine())
            .email(new Scanner(System.in).nextLine())
            .password(new Scanner(System.in).nextLine())
            .address(new Scanner(System.in).nextLine())
            .money(new Scanner(System.in).nextInt())
            .build();
         db.addUser(n);
         this.index();
    }
    public void login(){
        if(db.length()==0){
            System.out.println("doesn't have any account register first");
            register();
        }
        else {
        System.out.println("Login your account fill id->password");
        this.session = db.authenricate(
                new Scanner(System.in).nextLine(),
                new Scanner(System.in).nextLine());
        this.index();
        }
       }
    public void logout(){
        this.session = null;
        System.out.println("Logout success!!");
        index();
    }
    public void seeScore(){
        
    }
    public void play(){
        
    }
    public void viewProfile(){
        System.out.println("UserID :"+session.getID()+"\nAddress : "+session.getAddress());
        index();
    }
}
public class Game {

    
    public static void main(String[] args) {
        Server serv1 = new Server();
    }
    
}
