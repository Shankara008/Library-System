package Library_System;
import java.util.Scanner;
//import CS105_Assignment02.Menu;

public class Driver {
    public static void main(String[] args) {

        Scanner Scan = new Scanner(System.in);
        Menu menu = new Menu();

        String result = "y";

        while (result.equals("y") || result.equals("Y")) {

            menu.menuStarter();
            System.out.print("Do you wish to Go to the main Menu (Y/N) : ");
            result = Scan.nextLine();
            if (result.equals("y")) {
                continue;
            } else if(result.equals("n") || result.equals("N")){
                System.out.print("Do you wish to exit the program!....(Y/N) : ");
                String answer00 = Scan.nextLine();
                if(answer00.equals("Y") || answer00.equals("y")){
                    break;
                }
                result = "y";
                continue;
            }else{
                result = "y";
                continue;
            }
        }
    }
}
