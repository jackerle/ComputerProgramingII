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
    public String getPass(){
        return this.password;
    }
    
}
class DB{
    ArrayList<User> users = new ArrayList<>();
    public void addUser(User u){
        users.add(u);
        System.out.println("registered success!\nYour id is:"+u.getID());
    }
    public User authenricate(String id,String pass){
        if(!users.isEmpty()){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getID().equals(id)){
                  System.out.println(users.get(i).getID());
                  return users.get(i);
                /*if(users.get(i).getPass().equals(pass)){
                    System.out.println("Login Succes! :"+users.get(i).getID());
                    return users.get(i);
                }
                else{
                    System.out.println("password not match!");
                    break;
                }*/
            }
         
        }
        }
        System.out.println("ID doesn't exist!");
        return null;
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
         User m = new User()
            .email("zeustololisis@gmail.com")
            .address("nakhonprathom")
            .password("19114198")
            .userId("darkness")
            .money(10000)
            .build();
         db.addUser(n);
         db.addUser(m);
    }
    public void login(){
        db.authenricate("jackerle","19114198");
    }
    public void seeScore(){
        
    }
    public void play(){
        
    }
}
public class Game {

    
    public static void main(String[] args) {
        Server serv1 = new Server();
        //----------------Register-------------------------------------------
        serv1.register();
        serv1.login();
    
        
        //--------------------------------------------------------------------
    }
    
}
