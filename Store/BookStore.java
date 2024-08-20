package Library_System.Store;
import Library_System.LendItems.Book;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookStore implements Serializable{

    static List<Book> Collection;

    public BookStore(){
        Collection = new ArrayList<Book>();
    }

    public void addBook(Book book){

        if (Collection.contains(book)) {
            book.setAvailCopies(book.getAvailCopies() + 1);
        } else {
            Collection.add(book);
            System.out.println("Book added successfully...");
        }
    }


    public String toString(){
        String total = "\n";

        Iterator i = Collection.iterator();
        while(i.hasNext()){
            //here it is casted to a book object!...
            Book book = (Book)i.next();
            total = total + book.toString();
        }
        return total;
    }


    public Book searchBook(String name){

        for(int i = 0; i < Collection.size(); i++) {
            if(Collection.get(i).getName().equals(name)){
                return Collection.get(i);
            }
        }
        return null;
    }

    public void removeBook(String name){

        Collection.remove(searchBook(name));

    }

    public void printBooks(){
        for(int i = 0; i < Collection.size(); i++) {
            Collection.get(i).printDetails();
        }
    }
}
