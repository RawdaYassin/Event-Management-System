
package Pages;

import Classes.ProjectManger;
import java.util.Scanner;

public class ProjectManagerPage {

    public static void main(String[] args) throws Exception{
      
        ProjectManger projectmanger = new ProjectManger();
        Scanner input = new Scanner(System.in);
        if(projectmanger.login()){
        int decision = 0;
        while (decision != 1) {
                System.out.println("""
                        Hello, Project Manager!
                        Choose what you want to do?
                        [1] Receive customer requests
                        [2] Send Customer Requests to service providers
                        [3] Contact with customers
                        [4] Show bill for customer          
                        """);
                int choice = input.nextInt();
                switch (choice) {
                    case 1 -> projectmanger.receiveRequests();
                    case 2 -> projectmanger.sendRequests();
                    case 3 -> projectmanger.contactCustomer();
                    //case 4 -> projectmanger.showBill();
                    default -> System.out.println("Invalid number.");
                }
                System.out.println("[1] Return to the roles menu \n[2]Continue");
                System.out.print("Decision: ");
                decision = input.nextInt();
            }
        }else{
            System.out.println("An error occurr while logging in, please check your account or try again.");
           
        }
    }
    
}
