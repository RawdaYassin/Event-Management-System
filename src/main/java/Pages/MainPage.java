
package Pages;

import java.util.Scanner;


public class MainPage {
 
   public static void main(String[] args)throws Exception {
       
        Scanner input = new Scanner(System.in);
        int decision = 0;
        while (decision != 1) {
            System.out.println("""
                    Hello, user!
                    Choose your role?
                    [1] Admin
                    [2] Customer
                    [3] Service Provider
                    [4] Project Manager
                    """);
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> AdminPage.main(args);
                case 2 -> CustomerPage.main(args);
                case 3 -> ServiceProviderPage.main(args);
                case 4 -> ProjectManagerPage.main(args);
                default -> System.out.println("Invalid number.");
            }
            System.out.println("[1] Exit Program \n[2]Continue");
            System.out.print("Decision: ");
            decision = input.nextInt();
        }
    }
    
}
