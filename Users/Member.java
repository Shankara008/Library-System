package Library_System.Users;

public class Member extends User{

    public Member(String id,String name,String email,int age){
        super(id,name,email,age);
        this.setBookLimit(5);
        this.setLevel(3);
    }
}
