package Library_System.Store;

import Library_System.LendItems.*;
import Library_System.Users.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserStore implements Serializable {
    public static List<User> users;
    public UserStore(){
        users = new ArrayList<User>();
    }

    public User searchUser(String id){

        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getID().equals(id)){
                return users.get(i);
            }
        }
        return null;
    }

    public void addUser(User user){

        if(user.getBookLimit() == 0) {
            System.out.println("Cannot burrow anymore books!...");
        }else{
            if (users.isEmpty()) {
                users.add(user);
                System.out.println("User added successfully...");
                user.setBookLimit(user.getBookLimit() - 1);
            } else {
                if (users.contains(user)) {
                    System.out.println("User exists!...");
                } else {
                    users.add(user);
                    user.setBookLimit(user.getBookLimit() - 1);
                    System.out.println("User added successfully...");
                }
            }
        }
    }

    public void settingTime(String exid, String exname){
        searchUser(exid).searchBurrowedBook(exname).setLendingTime(searchUser(exid).searchBurrowedBook(exname).getLendingTime() + 7);
        System.out.println("Time Extended for 7 Days!...");
        System.out.println("Total Time to return the Book : " + searchUser(exid).searchBurrowedBook(exname).getLendingTime());
    }

    public String idGenerator(){
        String ID = new String();
        int count = users.size() + 1;

        if(count < 10){
            ID = "U000" + count;
        }else if(count < 100 && count > 10){
            ID = "U00" + count;
        }else if(count < 1000 && count > 100){
            ID = "U0" + count;
        }else if(count < 10000 && count > 1000){
            ID = "U" + count;
        }

        //if the id is already there!.. we can use this bit of code to skip that id and create the next id again and again... ;)
        while(this.searchUser(ID) != null){
            count += 1;
            if(count < 10){
                ID = "U000" + count;
            }else if(count < 100 && count > 10){
                ID = "U00" + count;
            }else if(count < 1000 && count > 100){
                ID = "U0" + count;
            }
        }
        return ID;
    }

    public void printUsers(){
        System.out.println("_________ All the Users and their Info ________");
        for(int i = 0; i < users.size(); i++) {
            users.get(i).printUser();
        }
    }

    public void removeUser(String Id){
        users.remove(searchUser(Id));
        System.out.println("User Removed successfully!...");
    }
    public void addItems(String id, Book book1){
        Book book2 = new Book(book1.getName(), book1.getAuthor(), book1.getPublisher(), book1.getNumCopies(), book1.getAvailCopies(), book1.isAgeRestrict());
        searchUser(id).getItems().add(book2);
    }
    public void removeItems(String id, Book book1){
        searchUser(id).getItems().remove(book1);
    }

}
