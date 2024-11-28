
package Pages;

import Classes.Customer;
import java.util.Scanner;

public class CustomerPage {

    
    public static void main(String[] args) throws Exception {
        
        Customer customer = new Customer();
        Scanner input = new Scanner(System.in);
        int decision = 0;
        while (decision != 1) {
                System.out.println("""
                        Hello, Customer!
                        Choose what you want to do?
                        [1] Create account
                        [2] Login (Already have an account)          
                        [3] Book event
                        [4] Manage booking
                        [5] Contact with project manager
                        [6] Show bill          
                        """);
                int choice = input.nextInt();
                switch (choice) {
                    case 1 -> customer.createAccount();
                    case 2 -> customer.login();
                    case 3 -> customer.bookEvent();
                    case 4 -> customer.manageBooking();
                    case 5 -> customer.contactProjectManager();
                    case 6 -> customer.showBill();
                    default -> System.out.println("Invalid number.");
                }
                System.out.println("[1] Return to the roles menu \n[2]Continue");
                System.out.print("Decision: ");
                decision = input.nextInt();
            }
        
    }
    
}
