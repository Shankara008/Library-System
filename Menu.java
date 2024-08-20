package Library_System;

import java.util.Scanner;
import Library_System.LendItems.*;
import Library_System.Store.*;
import Library_System.Users.*;

public class Menu {
    UserStore userstore = new UserStore();
    BookStore library = new BookStore();
    Scanner Scan = new Scanner(System.in);

    //Several Objects to run the system...
    User a1 = new Administrator("U0001", "Shankara", "shankara.devapriya@gmail.com", 21);
    Book b1 = new Book("The Jungle","Shanky","Mihira Publishers",4,4,false);
    Book b2 = new Book("The Sea","Chapa","Mihira Publishers",5,4,true);
    Book b3 = new Book("Lovers Quarrel","Billy","Dakota Publishers",3,2,true);
    Book b4 = new Book("Alex's Adventures","John Marston","Mihira Publishers",2,2,false);
    Book j1 = new Journal("The Times","James Downs","Binara Publishers",3,1,false,5);
    Book M1 = new Magazine("The Traveller","Terry Jeffords","Senura Publishers",1,1,false,4,2001);

    public void menuStarter(){

        //First to run the program As an Administrator!...
        if(userstore.searchUser(a1.getID()) != a1){
            userstore.addUser(a1);
            library.addBook(b1);
            library.addBook(b2);
            library.addBook(b3);
            library.addBook(b4);
            library.addBook(j1);
            library.addBook(M1);
        }
        System.out.println("------------------------------------------------");
        System.out.println("\t\t\t WELCOME TO THE LIBRARY");
        System.out.println("------------------------------------------------");
        System.out.println();
        System.out.println("Default ID : " + a1.getID());
        System.out.print("Enter User ID: ");
        String userID = Scan.next();
        User Starter = userstore.searchUser(userID);

        if(Starter != null){
                this.theMenu(Starter);
        }else{
            System.out.println("User Does Not Exist!...");
        }
    }


    public void theMenu(User currentUser) {

        if(currentUser.getLevel() == 1){
            int answer1;
            System.out.println("(1) Add new User");
            System.out.println("(2) Remove User");
            System.out.println("(3) Update User");
            System.out.print("Enter the relevant number : ");
            answer1 = Scan.nextInt();
            Scan.nextLine();
            System.out.println("______________________________________");
            switch(answer1){
                case 1:
                    System.out.print("Enter the User Level : ");
                    int newLevel = Scan.nextInt();
                    Scan.nextLine();
                    if(newLevel == 1){
                        System.out.println("_________ You are adding a Admin __________");
                        System.out.print("Enter the Name : ");
                        String newName1 = Scan.nextLine();
                        System.out.print("Enter the Email : ");
                        String newEmail1 = Scan.nextLine();
                        System.out.print("Enter the Age : ");
                        int newAge1 = Scan.nextInt();
                        Scan.nextLine();
                        String ida = userstore.idGenerator();
                        userstore.addUser(new Administrator(ida,newName1,newEmail1,newAge1));
                        System.out.println("New Admin Added. Remember your ID : " + userstore.searchUser(ida).getID());

                    }else if(newLevel == 2){
                        System.out.println("_________ You are adding a librarian __________");
                        System.out.print("Enter the Name : ");
                        String newName0 = Scan.nextLine();
                        System.out.print("Enter the Email : ");
                        String newEmail0 = Scan.nextLine();
                        System.out.print("Enter the Age : ");
                        int newAge0 = Scan.nextInt();
                        Scan.nextLine();
                        String idl = userstore.idGenerator();
                        userstore.addUser(new Librarian(idl, newName0, newEmail0, newAge0));
                        System.out.println("New Librarian Added. Remember your ID : " + userstore.searchUser(idl).getID());
                    }else if(newLevel == 3){
                        System.out.println("_________ You are adding a Member __________");
                        System.out.print("Enter the Name : ");
                        String newName2 = Scan.nextLine();
                        System.out.print("Enter the Email : ");
                        String newEmail2 = Scan.nextLine();
                        System.out.print("Enter the Age : ");
                        int newAge2 = Scan.nextInt();
                        Scan.nextLine();
                        String idm = userstore.idGenerator();
                        userstore.addUser(new Member(idm, newName2, newEmail2, newAge2));
                        System.out.println("New Member Added. Remember your ID : " + userstore.searchUser(idm).getID());
                    }else{
                        System.out.println("Invalid Level!...");
                        userstore.printUsers();
                    }
                    break;
                case 2:
                    System.out.print("Enter the userID : ");
                    String ID = Scan.nextLine();
                    if(userstore.searchUser(ID) != null){
                        userstore.removeUser(ID);
                    }else{
                        System.out.println("User Does not Exist!...");
                    }
                    break;
                case 3:
                    System.out.println("------ User Updating!....");
                    System.out.print("Enter the User ID : ");
                    String id = Scan.nextLine();
                    if(userstore.searchUser(id) != null){
                        System.out.print("Enter the NewLevel : ");
                        int newUpLevel = Scan.nextInt();
                        Scan.nextLine();
                        if(newUpLevel == 2){
                            userstore.addUser(new Librarian(userstore.idGenerator(),userstore.searchUser(id).getUserName(),userstore.searchUser(id).getEmail(),userstore.searchUser(id).getAge()));
                        }else if(newUpLevel == 3){
                            userstore.addUser(new Member(userstore.idGenerator(),userstore.searchUser(id).getUserName(),userstore.searchUser(id).getEmail(),userstore.searchUser(id).getAge()));
                        }else{
                            userstore.addUser(new Administrator(userstore.idGenerator(),userstore.searchUser(id).getUserName(),userstore.searchUser(id).getEmail(),userstore.searchUser(id).getAge()));
                        }
                        userstore.removeUser(id);
                    }else{
                        System.out.println("User Does not Exist!...");
                    }
                    break;
            }

        }else if(currentUser.getLevel() == 2){
            int answer2;
            System.out.println("(1) Add Copies");
            System.out.println("(2) Add New Book");
            System.out.println("(3) Remove Copies");
            System.out.println("(4) Extend Time");
            System.out.println("(5) Print Books");
            System.out.print("Enter the relevant number : ");
            answer2 = Scan.nextInt();
            Scan.nextLine();
            System.out.println("______________________________________");
            switch(answer2){
                case 1:
                    System.out.println("----------Adding Copies ------------");
                    System.out.print("Enter the Name : ");
                    String name0 = Scan.nextLine();
                    System.out.print("How many Copies : ");
                    int num = Scan.nextInt();
                    Scan.nextLine();
                    library.searchBook(name0).addCopies(num);
                    break;
                case 2:
                    System.out.println("------------Adding a Book ------------");
                    System.out.println("(1) Book");
                    System.out.println("(2) Journal");
                    System.out.println("(3) Magazine");
                    System.out.print("What is the type of the Book : ");
                    int answer = Scan.nextInt();
                    Scan.nextLine();
                    System.out.println("______________________________________");

                    System.out.print("Enter the name : ");
                    String name = Scan.nextLine();
                    System.out.print("Enter the Author : ");
                    String author = Scan.nextLine();
                    System.out.print("Enter the Publisher : ");
                    String pub = Scan.nextLine();
                    System.out.print("Enter the Number of Copies : ");
                    int numC = Scan.nextInt();
                    Scan.nextLine();
                    System.out.print("Enter the Number of Available Copies : ");
                    int numA = Scan.nextInt();
                    Scan.nextLine();

                    while(numC < numA){
                        System.out.println("NUMBER OF COPIES CANNOT BE LESS THAN AVAILABLE COPIES!...");
                        System.out.print("Enter the Number of Copies : ");
                        numC = Scan.nextInt();
                        Scan.nextLine();
                        System.out.print("Enter the Number of Available Copies : ");
                        numA = Scan.nextInt();
                        Scan.nextLine();
                    }
                    System.out.print("Age Restriction : ");
                    boolean res = Scan.nextBoolean();
                    if(answer == 1){
                        library.addBook(new Book(name,author,pub,numC,numA,res));
                    }else if(answer == 2){
                        System.out.println("Enter the Volume Number : ");
                        int vol = Scan.nextInt();
                        Scan.nextLine();
                        library.addBook(new Journal(name,author,pub,numC,numA,res,vol));
                    }else{
                        System.out.println("Enter the Issue Number : ");
                        int issue = Scan.nextInt();
                        Scan.nextLine();
                        System.out.println("Enter the Year : ");
                        int year = Scan.nextInt();
                        Scan.nextLine();
                        library.addBook(new Magazine(name,author,pub,numC,numA,res,issue,year));
                    }
                    break;
                case 3:
                    System.out.println("----------Removing a Book --------");
                    System.out.print("Enter the Name : ");
                    String name1 = Scan.nextLine();
                    if(library.searchBook(name1) == null){
                        System.out.println("Book Does not exist!...");
                    }else if(library.searchBook(name1).getAvailCopies() <= 1){
                        library.removeBook(name1);
                        System.out.println("Book Removed!...");
                    }else{
                        System.out.print("Enter the number of copies you need to remove: ");
                        int num0 = Scan.nextInt();
                        Scan.nextLine();
                        if(num0 == 1){
                            library.searchBook(name1).setNumCopies(library.searchBook(name1).getNumCopies() - 1);
                            library.searchBook(name1).setAvailCopies(library.searchBook(name1).getAvailCopies() - 1);
                            System.out.println("A Copy Removed!...");
                        }else if(num0 < library.searchBook(name1).getAvailCopies()){
                            library.searchBook(name1).removeCopies(num0);
                        }else if(num0 == library.searchBook(name1).getAvailCopies()){
                            library.removeBook(name1);
                        }else{
                            System.out.println("Cannot remove that amount of copies!..");
                            System.out.println("Number of Available copies are : " + library.searchBook(name1).getAvailCopies());
                            System.out.println("Operation cancelled...");
                        }
                    }
                    break;
                case 4:
                    System.out.println("-----------Extending Time ----------");
                    System.out.print("Enter the userID : ");
                    String exId = Scan.nextLine();
                    System.out.print("Enter the Book Name : ");
                    String exBook = Scan.nextLine();
                    userstore.settingTime(exId,exBook);
                    break;
                case 5:
                    System.out.println("(1) Print all Books.");
                    System.out.println("(2) Print a Single Book.");
                    System.out.println("(3) Print Books Burrowed by a User.");
                    System.out.print("Enter the relevant number : ");
                    int answer4 = Scan.nextInt();
                    Scan.nextLine();
                    if(answer4 == 1){
                        System.out.println("---------------- THE INFO OF ALL BOOKS --------------");
                        library.printBooks();
                    }else if(answer4 == 2){
                        System.out.print("Enter the Book Name : ");
                        String name2 = Scan.nextLine();
                        if(library.searchBook(name2) != null){
                            library.searchBook(name2).printDetails();
                        }else{
                            System.out.println("Book Does not Exist!...");
                        }
                    }else if(answer4 == 3){
                        System.out.print("Enter the User ID : ");
                        String name3 = Scan.nextLine();
                        if(userstore.searchUser(name3) != null){
                            userstore.searchUser(name3).printBurrowedBooks();
                        }else{
                            System.out.println("User Does not Exist!...");
                        }
                    }else{
                        System.out.println("Wrong input!...");
                    }
                    break;
            }

        }else{
            int answer3;
            System.out.println("(1) Burrow a Book");
            System.out.println("(2) Return a book");
            System.out.println("(3) Print a Book");
            System.out.print("Enter the relevant number : ");
            answer3 = Scan.nextInt();
            Scan.nextLine();
            System.out.println("______________________________________");
            switch(answer3){
                case 1:

                    System.out.print("Enter the Book Name : ");
                    String name = Scan.nextLine();
                    if(library.searchBook(name) != null){
                        if(userstore.searchUser(currentUser.getID()).getBookLimit() < 1 || library.searchBook(name).getAvailCopies() < 1){
                            System.out.println("User Cannot burrow anymore books!...");
                        }else{
                            if(library.searchBook(name).isAgeRestrict() && userstore.searchUser(currentUser.getID()).getAge() < 18){
                                System.out.println("This Book is Age restricted for you!...");
                                System.out.println("Operation terminated!...");
                            }else{
                                userstore.searchUser(currentUser.getID()).setBookLimit(userstore.searchUser(currentUser.getID()).getBookLimit() - 1);
                                library.searchBook(name).setAvailCopies(library.searchBook(name).getAvailCopies() - 1);
                                userstore.addItems(currentUser.getID(), library.searchBook(name));
                                System.out.println("Book lent!...");
                                System.out.println();
                            }
                        }
                    }else{
                        System.out.println("Book is Not Available!...");
                    }
                    break;

                case 2:
                    System.out.print("Enter the Book Name : ");
                    String name0 = Scan.nextLine();
                    if(library.searchBook(name0).getAvailCopies() >= library.searchBook(name0).getNumCopies()){
                        System.out.println("User Cannot return anymore books!...");
                    }else{
                        userstore.searchUser(currentUser.getID()).setBookLimit(userstore.searchUser(currentUser.getID()).getBookLimit() + 1);
                        library.searchBook(name0).setAvailCopies(library.searchBook(name0).getAvailCopies() + 1);
                        userstore.removeItems(currentUser.getID(), currentUser.searchBurrowedBook(name0));
                        System.out.println("Book successfully returned...");
                    }
                    break;
                case 3:
                    System.out.print("Enter the Book Name : ");
                    String name1 = Scan.nextLine();
                    if(library.searchBook(name1) != null){
                        library.searchBook(name1).printDetails();
                    }else{
                        System.out.println("Book Does not Exist!...");
                    }
                    break;
            }
        }
    }
}
