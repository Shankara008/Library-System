package Library_System.Users;

import Library_System.LendItems.Book;
import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String ID;
    private String userName;
    private String email;
    private int age;
    private int bookLimit;
    private int level;
    private List<Book> Items;


    User(String id,String name,String email,int age){
        this.ID = id;
        this.userName = name;
        this.email = email;
        this.age = age;
        Items = new ArrayList<>();
    }

    public List<Book> getItems() {
        return Items;
    }

    public void setItems(List<Book> items) {
        Items = items;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBookLimit() {
        return bookLimit;
    }

    public void setBookLimit(int bookLimit) {
        this.bookLimit = bookLimit;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public void printUser(){
        String type;

        if(this.level == 1){
            type = "Administrator";
        }else if(this.level == 2){
            type = "Librarian";
        }else{
            type = "Member";
        }
        System.out.println("-------------------- Details of the "+ type +" ------------- ");
        System.out.println("ID \t\t: " + this.ID);
        System.out.println("Name \t: " + this.userName);
        System.out.println("Email \t: " + this.email);
        System.out.println("Age \t: " + this.age);
        System.out.println("------------------------------------------------------------- ");
    }
    public Book searchBurrowedBook(String name){

        for(int i = 0; i < Items.size(); i++) {
            if(this.Items.get(i).getName().equals(name)){
                return this.Items.get(i);
            }
        }
        return null;
    }
    public void printBurrowedBooks(){
        for(int i = 0; i < Items.size(); i++) {
            this.Items.get(i).printDetails();
        }
    }
}
