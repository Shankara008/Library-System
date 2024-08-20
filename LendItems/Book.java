package Library_System.LendItems;

public class Book {
    String gg;
    private String name;
    private String author;
    private String publisher;
    private int numCopies;
    private int availCopies;
    private boolean ageRestrict;
    private int lendingTime;

    public Book(String name, String author, String pub, int nCopies, int aCopies, boolean ageRestrict){
        this.name = name;
        this.author = author;
        this.publisher = pub;
        this.numCopies = nCopies;
        this.availCopies = aCopies;
        this.ageRestrict = ageRestrict;
        this.lendingTime = 14;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumCopies() {
        return numCopies;
    }

    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

    public int getAvailCopies() {
        return availCopies;
    }

    public void setAvailCopies(int availCopies) {
        this.availCopies = availCopies;
    }

    public boolean isAgeRestrict() {
        return ageRestrict;
    }

    public void setAgeRestrict(boolean ageRestrict) {
        this.ageRestrict = ageRestrict;
    }

    public int getLendingTime() {
        return lendingTime;
    }

    public void setLendingTime(int lendingTime) {
        this.lendingTime = lendingTime;
    }

    public void addCopies(int number){
        this.numCopies = number + this.numCopies;
        this.availCopies = number + this.availCopies;
        System.out.println("Number of copies : " + this.numCopies + "\t | Number of Available Copies: " + this.availCopies);

    }
    public void removeCopies(int number){
        this.numCopies = this.numCopies - number;
        this.availCopies = this.availCopies - number;
        System.out.println(number + " Number of copies have been removed!..");
    }
    public void printDetails(){
        System.out.println("-------------------- Details of the book --------------------- ");
        System.out.println("Name \t\t\t\t: " + this.name);
        System.out.println("Author \t\t\t\t: " + this.author);
        System.out.println("Publisher \t\t\t: " + this.publisher);
        System.out.println("Total copies \t\t: " + this.numCopies);
        System.out.println("Available Copies \t: " + this.availCopies);
        System.out.println("Age restriction \t: " + this.isAgeRestrict());
        System.out.println("------------------------------------------------------------- ");
    }

}
