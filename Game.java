import java.util.ArrayList;
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
        this.userId = id;
        return this;
    }
    public User money(int m){
        this.money = money;
        return this;
    }
    public User password(String p){
        this.password = password;
        return this;
    }
    public User email(String email){
        this.email =email;
        return this;
    }
    public User address(String a){
        this.address = address;
        return this;
    }
    public User build(){
        return new User(this);
    }
    public String getID(){
        return this.userId;
    }
    
}
class DB{
    ArrayList<User> users = new ArrayList<>();
    public void addUser(User u){
        users.add(u);
        System.out.println("registered success!\nYour id is:"+u.getID());
    }
    
}
class Admin{
    
}
class Server{
    DB db = new DB();
    public void register(){
         User n = new User()
            .email("zeustololisis@gmail.com")
            .address("nakhonprathom")
            .password("19114198")
            .userId("jackerle")
            .money(10000)
            .build();
         db.addUser(n);
    }
    public void login(){
        
    }
    public void seeScore(){
        
    }
}
public class Game {

    
    public static void main(String[] args) {
        Server serv1 = new Server();
        //----------------Register-------------------------------------------
        serv1.register();
    
        
        //--------------------------------------------------------------------
    }
    
}
