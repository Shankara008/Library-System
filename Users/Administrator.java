package Library_System.Users;


public class Administrator extends User{
    public Administrator(String id, String name, String email, int age){
        super(id,name,email,age);
        this.setBookLimit(5);
        this.setLevel(1);
    }
}
