package Library_System.LendItems;

public class Magazine extends Book{

    private int issueNum;
    private int year;

    public Magazine(String name, String author, String pub, int nCopies, int aCopies, boolean ageRestrict,int issue,int year) {
        super(name, author, pub, nCopies, aCopies, ageRestrict);
        this.issueNum = issue;
        this.year = year;
    }

    public int getIssueNum() {
        return issueNum;
    }

    public void setIssueNum(int issueNum) {
        this.issueNum = issueNum;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void printDetails(){
        System.out.println("-------------------- Details of the Magazine ---------------");
        System.out.println("Name \t\t\t\t: " + this.getName());
        System.out.println("Author \t\t\t\t: " + this.getAuthor());
        System.out.println("Publisher \t\t\t: " + this.getPublisher());
        System.out.println("Issue Number \t\t: " + this.issueNum);
        System.out.println("Printed Year \t\t: " + this.year);
        System.out.println("Total copies \t\t: " + this.getNumCopies());
        System.out.println("Available Copies \t: " + this.getAvailCopies());
        System.out.println("Age restriction \t: " + this.isAgeRestrict());
        System.out.println("---------------------------------------------------------- ");
    }
}
