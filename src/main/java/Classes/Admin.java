
package Classes;

import static Classes.Methods.*;
import Interfaces.AdminInterface;
import java.util.Scanner;
import static Classes.Methods.*;

public class Admin extends User implements AdminInterface{
    
 private static int count = 1;
 
    public Admin()
    {
        super("AD", count);
         count++;
    }
    
    @Override
    public void addUser() {
        Scanner input = new Scanner(System.in);
        int decision = 0;
        while (decision != 1) {
            System.out.println("-----------Add_User--------------");
            System.out.print("Enter username: ");
            String username = input.nextLine();
            System.out.print("Enter E-mail: ");
            String email = input.nextLine();
            System.out.print("Enter Password: ");
            String password = input.nextLine();
            System.out.println("Enter Type \n1-ProjectManger\n2-ServiceProvider\n3-Customer\n4-Admin\n5-Exit");
            System.out.print("Role: ");
            int Type = input.nextInt();

            switch (Type) {
                case 1 ->                     {
                        int number =countFiles("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\ProjectMangers") + 1;
                        FileHandling fileManager = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\ProjectMangers\\PM" +number+".txt");
                        fileManager.writeFile("PM" +number + "\n" + username + "\n"+email+"\n" + password + "\n");
                        System.out.println("Registration successful for user: " + username);
                        break;
                    }
                case 2 ->                     {
                        int number =countFiles("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\ServiceProviders") + 1;
                        FileHandling fileManager = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\ServiceProviders\\SP" + number+".txt");
                        fileManager.writeFile("SP"+number + "\n" + username + "\n" +email+"\n"+ password + "\n");
                        System.out.println("Registration successful for user: " + username);
                        break;
                    }
                case 3 ->                     {
                  int number =countFiles("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Customers") + 1;
                        FileHandling fileManager = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Customers\\CUST" + number+".txt");
                        fileManager.writeFile("CUST"+number + "\n" + username + "\n" +email+"\n"+ password + "\n");
                        System.out.println("Registration successful for user: " + username);
                        break;
                    }
                case 4 ->                     {
                    int number =countFiles("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Admins") + 1;
                        FileHandling fileManager = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Admins\\AD" + number+".txt");
                        fileManager.writeFile("AD"+number + "\n" + username + "\n" + email+"\n"+password + "\n");
                        System.out.println("Registration successful for user: " + username);
                        break;
                    }
                case 5 -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid number!");
                    return;
                }
            }
                System.out.println("[1] Return to the Admin menu \n[2]Continue");
                System.out.print("Decision: ");
                decision = input.nextInt();
        }
    }

@Override
public void deleteUser() {
    
    //String idUser;
Scanner input = new Scanner(System.in);
        int decision = 0;
        while (decision != 1) {
        System.out.println("--------Delete_User---------");
        System.out.println("1-ProjectManger\n2-ServiceProvider\n3-Customer\n4-Admin");
        System.out.print("Role: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1 ->delete("Project Manger","D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\ProjectMangers\\");                    
            case 2 ->delete("Service Provider","D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\ServiceProviders\\");
            case 3 ->delete("Customer","D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Customers\\");
            case 4 ->delete("Admin","D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Admins\\");
            default -> {
                    System.out.println("Invalid number");
                }
        }
                System.out.println("[1] Return to the Admin menu \n[2]Continue");
                System.out.print("Decision: ");
                decision = input.nextInt();
    }
}

@Override
public void updateUser() {
    int choice;
    Scanner input = new Scanner(System.in);
        int decision = 0;
        while (decision != 1)  {
        System.out.println("--------Update_User---------");
        System.out.println("1-ProjectManger\n2-ServiceProvider\n3-Customer\n4-Admin");
        choice = input.nextInt();

        switch (choice) {
            case 1 -> update("Project Manager", "D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\ProjectMangers\\");
            case 2 -> update("Service Provider", "D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\ServiceProviders\\");
            case 3 -> update("Customer", "D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Customers\\");
            case 4 -> update("Admin", "D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Admins\\");
            default -> 
                System.out.println("Invalid choice. Please try again.");

        }
                System.out.println("[1] Return to the Admin menu \n[2]Continue");
                System.out.print("Decision: ");
                decision = input.nextInt();        
    }
}  

    @Override
   public void receiveRequests() {
                       Scanner input = new Scanner(System.in);
        int decision = 0;
        while (decision != 1){
            System.out.println("Enter the customer ID to receive : ");
            String customerID = input.nextLine();
            System.out.println("Enter the Request number to receive it:  ");
            String  idRequest = input.nextLine();

            FileHandling fileRequest = new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\Admins\\" + customerID + "." + idRequest + ".txt");
            if (fileRequest.checkFileExistence()) {
                System.out.println("Requests received successfully");
            } else {
                System.out.println("Error occurr while receiving");
            }
                System.out.println("[1] Return to the Admin menu \n[2]Continue");
                System.out.print("Decision: ");
                decision = input.nextInt();
        }
            
    }

   
   @Override
    public void sendRequest()
    {
        Scanner input = new Scanner(System.in);
        int decision = 0;
        while (decision != 1) 
        {
            System.out.print("Customer ID:");
            String CustomerID=input.nextLine();
            System.out.print("Request ID:");
            String RequestID=input.nextLine();
            System.out.print("PmID:");
            FileHandling AD=new FileHandling("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\Admins\\"+CustomerID+"."+RequestID+".txt");
            if(AD.checkFileExistence()){
               // Pm.createFile();
                AD.copyFile("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Requests\\ProjectMangers\\"+CustomerID+"."+RequestID+".txt");
                System.out.println("Request send to project manager successfully.");
            }else
                System.out.println("Request is not found, please try again");

                    System.out.println("[1] Return to the Admin menu \n[2]Continue");
                    System.out.print("Decision: ");
                    decision = input.nextInt();
        }
}

        public boolean login()
    {
        return super.login("D:\\College-Data\\Semester 3\\Programming 2\\EventManagementSystem\\DataBase\\Admins\\");
    }  
    
    
}
