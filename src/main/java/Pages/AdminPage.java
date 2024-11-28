

package Pages;

import Classes.Admin;
import java.util.Scanner;

public class AdminPage {

    public static void main(String[] args) throws Exception {
       
        Admin admin = new Admin();
        Scanner input = new Scanner(System.in);
        if(admin.login()){
        int decision = 0;
        while (decision != 1){
                System.out.println("""
                        Hello, admin!
                        Choose what you want to do?
                        [1] Receive customer requests
                        [2] Send customer requests to project manager
                        [3] Add User
                        [4] Update User
                        [5] Delete User          
                        """);
                int choice = input.nextInt();
                switch (choice) {
                    case 1 -> admin.receiveRequests();
                    case 2 -> admin.sendRequest();
                    case 3 -> admin.addUser();
                    case 4 -> admin.updateUser();
                    case 5 -> admin.deleteUser();
                    default -> System.out.println("Invalid number.");
                }
                System.out.println("[1] Return to the roles menu \n[2]Continue");
                System.out.print("Decision: ");
                decision = input.nextInt();
            }
        }else{
            System.out.println("An error occurr while logging in, please check your account or try again.");
            //MainPage.main(args);
        }
        
        
    }
    
}
