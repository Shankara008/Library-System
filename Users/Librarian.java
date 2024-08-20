package Library_System.Users;

public class Librarian extends User{
    public Librarian(String id, String name, String email, int age){
        super(id,name,email,age);
        this.setBookLimit(3);
        this.setLevel(2);
    }
}
