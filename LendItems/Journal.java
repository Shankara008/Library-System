package Library_System.LendItems;

public class Journal extends Book{
    private int volumeNum;
    public Journal(String name, String author, String pub, int nCopies, int aCopies, boolean ageRestrict,int volumeNum) {
        super(name, author, pub, nCopies, aCopies, ageRestrict);
        this.volumeNum = volumeNum;
    }

    public int getVolumeNum() {
        return volumeNum;
    }

    public void setVolumeNum(int volumeNum) {
        this.volumeNum = volumeNum;
    }

    public void printDetails(){
        System.out.println("-------------------- Details of the Journal ----------------- ");
        System.out.println("Name \t\t\t\t: " + this.getName());
        System.out.println("Author \t\t\t\t: " + this.getAuthor());
        System.out.println("Publisher \t\t\t: " + this.getPublisher());
        System.out.println("Volume \t\t\t\t: " + this.volumeNum);
        System.out.println("Total copies \t\t: " + this.getNumCopies());
        System.out.println("Available Copies \t: " + this.getAvailCopies());
        System.out.println("Age restriction \t: " + this.isAgeRestrict());
        System.out.println("------------------------------------------------------------");
    }
}
